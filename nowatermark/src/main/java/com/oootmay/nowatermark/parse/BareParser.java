package com.oootmay.nowatermark.parse;

import com.oootmay.nowatermark.result.BareResult;

/**
 * <p>项目文档： 解析器接口</p>
 *
 * @author liming
 * @version 1.0.0
 * @createTime 2022年01月31日 16:42:00
 */
public interface BareParser {
    /**
     * 获取无水印资源信息
     * @param link 复制的链接
     * @return 无水印资源信息
     */
    BareResult parse(String link) throws Exception;
}
