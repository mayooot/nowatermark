package com.oootmay.nowatermark.test;

import com.oootmay.nowatermark.parse.Platform;
import com.oootmay.nowatermark.result.BareResult;
import com.oootmay.nowatermark.service.BareService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * <p>项目文档： 测试去水印功能</p>
 *
 * @author liming
 * @version 1.0.0
 * @createTime 2022年01月31日 21:07:00
 */
@Slf4j
@SpringBootTest
public class ParseTest {
    @Resource
    private BareService bareService;

    /**
     * 解析校验
     * @param platform 平台
     * @param link 复制链接
     * @throws Exception
     */
    private void parse(Platform platform, String link) throws Exception {
        BareResult result = bareService.parse(link);
        log.info("===========================================================================================");
        log.info("{}：{}", platform.getName(), result.toString());
        log.info("===========================================================================================");
    }

    /**
     * 抖音图片作品测试
     */
    @Test
    void douYinImagesTest() throws Exception {
        parse(Platform.DOU_YIN,
                "2.33 eoq:/ 高铁上看到的可爱妹妹吖\n" +
                        "%骗你生女儿 %戴口罩的女孩  https://v.douyin.com/LB8wdw7/ 复制此链接，打开Dou音搜索，直接观看视频！");
    }

    /**
     * 抖音视频作品测试
     * @throws Exception
     */
    @Test
    void douYinVideoTest() throws Exception {
        parse(Platform.DOU_YIN,
                "6.10 yGv:/ 打牌吗？%看我造型say哇塞 %扑克牌 %看好别眨眼  https://v.douyin.com/LPuAVHL/ 复制此链接，打开Dou音搜索，直接观看视频！");
    }


    /**
     * 抖音图片作品测试
     */
    @Test
    void kuaiShouImagesTest() throws Exception {
        parse(Platform.KUAI_SHOU, "“你出现时，心动便有了定义” \"情侣头像 https://v.kuaishou.com/fTPSxd 复制此消息，打开【快手】直接观看！");
    }

    /**
     * 快手视频作品测试
     * @throws Exception
     */
    @Test
    void kuaiShouVideoTest() throws Exception {
        parse(Platform.KUAI_SHOU, "@易梦玲.* 发了一个快手作品，一起来看！https://v.kuaishou.com/gjlD4V 复制此消息，打开【快手】直接观看！");
    }

    @Test
    void testParsePlatformConfig() {
        for (Platform platform : ParsePlatformConfig.platforms) {
            System.out.println(platform);
        }
    }

    @Test
    void testGetItemId() {
        String url = "https://www.douyin.com/video/7057447552332893452?previous_page=app_code_link";
        int start = url.indexOf("/video/") + "/video/".length();
        int end = url.lastIndexOf("/");
        // 字符串截断后 //v.douyin.com/LPuAVHL
        System.out.println(url.substring(start, end));
        System.out.println(start);
        System.out.println(end);
    }


}
