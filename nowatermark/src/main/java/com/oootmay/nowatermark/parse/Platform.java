package com.oootmay.nowatermark.parse;

import com.oootmay.nowatermark.parse.parser.*;
/**
 * 支持的平台
 */
public enum Platform {

    DOU_YIN("抖音", "v.douyin.com", DouYinParser.class),
    KUAI_SHOU("快手", "v.kuaishou.com", KuaiShouParser.class),
    WEI_BO("微博", "video.weibo", WeiBoParser.class),
    XIAO_HONG_SHU("小红书", "xhslink.com", XiaoHongShuParser.class),
    KUAI_SHOU_QUICK("快手极速版", "v.kuaishouapp.com", KuaiShouParser.class);

    private final String name;
    private final String domain;
    private final Class<?> parserClass;

    Platform(String name, String domain, Class<?> parserClass) {
        this.name = name;
        this.domain = domain;
        this.parserClass = parserClass;
    }

    public String getName() {
        return name;
    }

    public String getDomain() {
        return domain == null ? "" : domain;
    }

    public Class<?> getParserClass() {
        return parserClass;
    }
}
