package com.oootmay.nowatermark.test;

import com.oootmay.nowatermark.parse.BareParser;
import com.oootmay.nowatermark.parse.Platform;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>项目文档： TODO</p>
 *
 * @author liming
 * @version 1.0.0
 * @createTime 2022年02月12日 21:18:00
 */
@SpringBootTest
public class KuaiShouQuickTest {

    @Test
    void test() {
        String url = "担当 有趣 温柔 上进 孝顺 可爱 坚定 谦虚 感恩 礼貌 懂事 积极 热心 善良 阳光 干净 。  https://v.kuaishouapp.com/s/DZf0IJlk 复制此消息，打开【快手极速版】直接观看！";
        String replace = url.replace("v.kuaishouapp.com", "v.kuaishou.com");
        System.out.println(replace);
    }


    public static final Platform[] platforms = new Platform[]{
            Platform.DOU_YIN,
            Platform.KUAI_SHOU,
            Platform.WEI_BO,
            Platform.XIAO_HONG_SHU,
            Platform.KUAI_SHOU_QUICK
    };


    /**
     * 获取解析器
     *
     * @param url 分享链接文字
     * @return 解析器
     */
    public BareParser getParser(String url) {
        for (Platform platform : platforms) {
            if (isPlatform(url, platform)) {
                System.out.println(platform.getName());
            }
        }
        return null;
    }

    /**
     * 平台归属
     *
     * @param url      复制的链接地址
     * @param platform 平台
     * @return 是否是 {@link Platform}
     */
    private boolean isPlatform(String url, Platform platform) {
        return url.contains(platform.getDomain());
    }
}
