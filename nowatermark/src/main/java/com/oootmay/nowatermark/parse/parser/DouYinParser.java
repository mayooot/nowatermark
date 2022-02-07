package com.oootmay.nowatermark.parse.parser;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONNull;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.oootmay.nowatermark.parse.BareParser;
import com.oootmay.nowatermark.parse.enums.MediaType;
import com.oootmay.nowatermark.result.BareResult;
import com.oootmay.nowatermark.utils.DownloadUtil;
import com.oootmay.nowatermark.utils.UrlUtil;
import com.oootmay.nowatermark.utils.UserAgentUtil;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 抖音解析器
 * ==============================================================
 * User-Agent Mobile
 * 1. 获取重定向地址
 * 2. 获取分享链接ID（路径形式）
 * 3. 请求接口获取数据json
 * 4. 解析获取想要的结果
 * --------------------------------------------------------------
 * 标题 -> item_list[0] -> desc
 * 封面 -> item_list[0] -> video -> cover -> url_list[0]
 * 视频 -> item_list[0] -> video => ( -> play_addr -> url_list[0], radio, width, height)
 * --------------------------------------------------------------
 * 图片 -> item_list[0] -> images => (url_list[0], null, null)
 * ==============================================================
 */
@Component
public class DouYinParser implements BareParser {

    /**
     * 获取视频接口地址
     */
    private static final String API = "https://www.iesdouyin.com/web/api/v2/aweme/iteminfo/?item_ids=";

    /**
     * 方法描述: 获取无水印资源信息
     *
     * @param url 复制的链接
     * @return 无水印资源信息
     */
    @Override
    public BareResult parse(String url) throws Exception {

        // 构建结果
        BareResult result = new BareResult();
        List<BareResult.Video> videos = new ArrayList<>();
        List<BareResult.Image> images = new ArrayList<>();

        String userAgent = UserAgentUtil.getOne();
        // 获取分享资源信息
        String jsonStr = Jsoup
                .connect(API + getItemId(UrlUtil.getRealUrl(userAgent, url)))
                .userAgent(userAgent)
                .ignoreContentType(true)
                .execute()
                .body();


        // 解析无水印资源
        JSONObject itemFirst = JSONUtil.parseObj(jsonStr)
                .getJSONArray("item_list")
                .getJSONObject(0);

        // 标题、封面
        result.setTitle(itemFirst.getStr("desc"))
                .setCover(new BareResult.Image(itemFirst.getJSONObject("video")
                        .getJSONObject("cover")
                        .getJSONArray("url_list")
                        .getStr(0)));

        if (!JSONNull.NULL.equals(itemFirst.get("images"))) {

            result.setType(MediaType.IMAGE);
            result.setImages(images);

            JSONArray imageJSONArray = itemFirst.getJSONArray("images");
            for (int i = 0; i < imageJSONArray.size(); i++) {
                // 官方图片信息
                String originUrl = imageJSONArray.getJSONObject(i).getJSONArray("url_list").getStr(0);
                // 下载到本地服务器，解决跨域问题
                String downloadUrl = DownloadUtil.download(originUrl, MediaType.IMAGE);
                images.add(new BareResult.Image(
                        downloadUrl,
                        imageJSONArray.getJSONObject(i).getInt("width"),
                        imageJSONArray.getJSONObject(i).getInt("height")
                ));
            }
        } else {
            JSONObject videoObject = itemFirst.getJSONObject("video");

            result.setType(MediaType.VIDEO);
            result.setVideos(videos);

            // 官方视频信息
            String originUrl = videoObject.getJSONObject("play_addr").getJSONArray("url_list").getStr(0).replace("playwm", "play");
            // 下载到本地服务器，解决跨域问题
            String downloadUrl = DownloadUtil.download(originUrl, MediaType.VIDEO);
            videos.add(new BareResult.Video(
                    downloadUrl,
                    videoObject.getStr("radio"),
                    videoObject.getInt("width"),
                    videoObject.getInt("height")
            ));
            }

        return result;
    }

    /**
     * 方法描述: 获取分享视频id
     *
     * @param url 分享链接
     */
    public String getItemId(String url) {
        int start = url.indexOf("/video/") + "/video/".length();
        int end = url.lastIndexOf("/");
        return url.substring(start, end);
    }

}
