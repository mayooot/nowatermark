package com.oootmay.nowatermark.test;

import com.oootmay.nowatermark.utils.StringUtil;
import org.aspectj.weaver.ast.Var;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>项目文档： TODO</p>
 *
 * @author liming
 * @version 1.0.0
 * @createTime 2022年02月01日 17:45:00
 */
@SpringBootTest
public class StringUtilTest {
    @Test
    void testFilterUrl() {
        // String url = StringUtil.filterUrl("@易梦玲.* 发了一个快手作品，一起来看！https://v.kuaishou.com/gjlD4V 复制此消息，打开【快手】直接观看！");
        // System.out.println(url);
        // String url = StringUtil.filterUrl("6.97 oDU:/ 呜呜呜人家也不想做搞笑女哇 所以快给我摸下pp%表情包 %艾特你想艾特的人 %搞笑女 @抖音小助手   https://v.douyin.com/LHMdmHe/ 复制此链接，打开Dou音搜索，直接观看视频！");
        // https://v.douyin.com/LHMdmHe/ 复制此链接，打开Dou音搜索，直接观看视频！

    }

    @Test
    void splitUrl() {
        String url = "<a href=\"http://v5-coldc.douyinvod.com/6aeabf3423b0f2c8a2e25fa35fb1bdeb/6200fceb/video/tos/cn/tos-cn-ve-15-alinc2/97406c058210404ba719db6f3392c5c3/?a=1128&amp;br=470&amp;bt=470&amp;cd=0%7C0%7C0%7C0&amp;ch=0&amp;cr=0&amp;cs=0&amp;cv=1&amp;dr=0&amp;ds=3&amp;er=&amp;ft=Oyq4lmZZI0rC17Xz4Th9D8Fxuhsd7Il4HqY&amp;l=202202051905050102080650503793BE25&amp;lr=&amp;mime_type=video_mp4&amp;net=0&amp;pl=0&amp;qs=0&amp;rc=M3F4czU6ZmkzOjMzNGkzM0ApNDw5Z2dpZWQ7Nzo6PGY0N2cpaGRqbGRoaGRmbWZvcXI0b2pqYC0tZC0vc3MtLy9eMF5iXjNeYDMxMmAvOmNwb2wrbStqdDo%3D&amp;vl=&amp;vr=\">Found</a>.\n";
        String s = url.split("\"")[1].split("\"")[0];
        System.out.println(s);
    }

}
