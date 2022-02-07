package com.oootmay.nowatermark.test;

import com.oootmay.nowatermark.utils.UrlUtil;
import com.oootmay.nowatermark.utils.UserAgentUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * <p>项目文档： TODO</p>
 *
 * @author liming
 * @version 1.0.0
 * @createTime 2022年02月01日 18:07:00
 */
@SpringBootTest
public class JsoupTest {
    private static final String API = "https://www.iesdouyin.com/web/api/v2/aweme/iteminfo/?item_ids=";
    private String url = "https://v.kuaishou.com/gfwDBM 复制此消息，打开【快手】直接观看！";

    @Test
    void testKuaiJsoup() throws IOException {
        Document document = Jsoup
                .connect(url)
                .userAgent(UserAgentUtil.getOne())
                .get();
        System.out.println(document);
        // Element videoElement = document.getElementsByTag("video").get(0);
        // // 标题
        // String title = videoElement.attr("alt");
        //
        // // 视频
        // String videoUrl = videoElement.attr("src");
        //
        // System.out.println(title);
        // System.out.println(videoUrl);

    }
    @Test
    void testGetRealUrl() throws IOException {
        String userAgent = UserAgentUtil.getOne();
        String realUrl = UrlUtil.getRealUrl(userAgent, url);
        System.out.println(realUrl);
    }
    @Test
    void testDocument() throws IOException {
        String userAgent = UserAgentUtil.getOne();
        // 获取分享资源信息
        String jsonStr = Jsoup
                .connect(API + getItemId(UrlUtil.getRealUrl(userAgent, url)))
                .userAgent(userAgent)
                .ignoreContentType(true)
                .execute()
                .body();
    }


    /**
     * 方法描述: 获取分享视频id
     *
     * @param url 分享链接
     */
    public String getItemId(String url) {
        int start = url.indexOf("/video/") + "/video/".length();
        int end = url.lastIndexOf("/");
        // System.out.println(url);
        // System.out.println(start);
        // System.out.println(end);
        // System.out.println(url.substring(start, end));
        return url.substring(start, end);
    }
}
