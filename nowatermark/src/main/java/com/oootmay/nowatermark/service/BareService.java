package com.oootmay.nowatermark.service;

import com.oootmay.nowatermark.parse.BareParser;
import com.oootmay.nowatermark.parse.ParserFactory;
import com.oootmay.nowatermark.result.BareResult;
import com.oootmay.nowatermark.utils.BizException;
import com.oootmay.nowatermark.utils.DownloadUtil;
import com.oootmay.nowatermark.utils.ErrorCode;
import com.oootmay.nowatermark.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>项目文档： 去除水印服务层</p>
 *
 * @author liming
 * @version 1.0.0
 * @createTime 2022年01月31日 16:38:00
 */
@Service
public class BareService {
    @Resource
    private ParserFactory parserFactory;

    public BareResult parse(String link) throws Exception {
        BareParser parser = parserFactory.getParser(link);
        if (parser == null) {
            throw new BizException(ErrorCode.NOT_SUPPORTED_PLATFORM_ERROR.value(), ErrorCode.NOT_SUPPORTED_PLATFORM_ERROR.msg());
        }
        return parser.parse(StringUtil.filterUrl(link));
    }
}
