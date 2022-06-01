package com.oootmay.nowatermark.parse.parser;

import com.alibaba.fastjson.JSONObject;
import com.oootmay.nowatermark.parse.BareParser;
import com.oootmay.nowatermark.parse.Platform;
import com.oootmay.nowatermark.parse.enums.MediaType;
import com.oootmay.nowatermark.result.BareResult;
import com.oootmay.nowatermark.utils.DownloadUtil;
import com.oootmay.nowatermark.utils.RestTemplateUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * <p>项目文档： 快手解析</p>
 *
 * @author liming
 * @version 1.0.0
 * @createTime 2022年02月07日 16:58:00
 */
@Component
public class KuaiShouParser implements BareParser {
    private static final Pattern ACCESS_PATTERN = Pattern.compile("(https?://v.kuaishou.com/[\\S]*)");

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private RestTemplateUtil restTemplateUtil;

    @Override
    public BareResult parse(String flag) throws Exception {
        if (flag.contains("v.kuaishouapp.com")) {
            flag = flag.replace("v.kuaishouapp.com", "v.kuaishou.com");
        }
        System.out.println(flag);
        // 构建结果
        BareResult result = new BareResult();
        List<BareResult.Video> videos = new ArrayList<>();
        List<BareResult.Image> images = new ArrayList<>();
        Matcher matcher = ACCESS_PATTERN.matcher(flag);
        if (matcher.find()) {
            String url = matcher.group(1);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("User-Agent", "Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Mobile Safari/537.36");

            httpHeaders.set("Referer", url);
            if (url.contains("v.kuaishou.com")) {
                // 获取重定向后的地址
                url = restTemplate.headForHeaders(url).getLocation().toString();
            }
            if (url.contains("/fw/photo/")) {
                // 获取网页内容，从而获取pageData
                String htmlContent = restTemplateUtil.getForObject(url, httpHeaders, String.class);
                Document document = Jsoup.parse(htmlContent);
                Elements elements = document.getElementsByTag("script");
                for (int i = 0; i < elements.size(); i++) {
                    if (elements.get(i).childNodeSize() > 0) {
                        Matcher matcherForPageData = Pattern.compile("window.pageData[\\s]*=[\\s]*(.*)[\\s]*").matcher(elements.get(i).childNode(0).toString());
                        if (matcherForPageData.find()) {
                            String pageData = matcherForPageData.group(1);
                            JSONObject pageDataOb = JSONObject.parseObject(pageData);
                            // 快手视频有图片（横向滑动，纵向滑动）和视频
                            JSONObject mediaJob = pageDataOb.getJSONObject("video");
                            // video.images(横向)、image_long（纵向）
                            String photoType = mediaJob.getString("type");
                            if ("video".equals(photoType)) {
                                // 处理视频
                                result.setVideos(videos)
                                        .setType(MediaType.VIDEO)
                                        .setTitle(mediaJob.getString("caption"))
                                        .setCover(new BareResult.Image(mediaJob.getString("poster")));
                                String originUrl = mediaJob.getString("srcNoMark");
                                String downloadUrl = DownloadUtil.download(originUrl, MediaType.VIDEO, Platform.KUAI_SHOU);
                                videos.add(new BareResult.Video(downloadUrl,
                                        null,
                                        Integer.parseInt(mediaJob.getString("width")),
                                        Integer.parseInt(mediaJob.getString("height"))
                                ));
                            }
                            if ("images".equals(photoType) || "image_long".equals(photoType)) {
                                // 处理图集
                                result.setType(MediaType.IMAGE)
                                        .setTitle(mediaJob.getString("caption"))
                                        .setCover(new BareResult.Image(mediaJob.getString("poster")));

                                String imageCDN = "https://" + mediaJob.getString("imageCDN");
                                images = mediaJob.getJSONArray("images").stream().map(image -> {
                                    JSONObject imageJob = ((JSONObject) image);
                                    BareResult.Image originImage = new BareResult.Image();
                                    String originUrl = imageCDN + imageJob.getString("path");
                                    String downloadUrl = null;
                                    try {
                                        downloadUrl = DownloadUtil.download(originUrl, MediaType.IMAGE, Platform.KUAI_SHOU);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    originImage.setUrl(downloadUrl);
                                    return originImage;
                                }).collect(Collectors.toList());
                                result.setImages(images);
                            }
                        }
                    }

                }
            }
        }
        return result;
    }

}


