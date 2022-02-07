package com.oootmay.nowatermark.parse;

/**
 * 平台配置
 */
class ParsePlatformConfig {

    /**
     * 解析的平台集合
     * 声明一个Platform类型的数组，里面的值是Platform枚举里的数据，
     * 所以遍历platforms数组，要用Platform遍历
     * for (Platform platform : ParsePlatformConfig.platforms)
     */
    public static final Platform[] platforms = new Platform[]{
            Platform.DOU_YIN,
            Platform.KUAI_SHOU,
            Platform.WEI_BO,
            Platform.XIAO_HONG_SHU
    };
}
