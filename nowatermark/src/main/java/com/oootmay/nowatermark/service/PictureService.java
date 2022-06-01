package com.oootmay.nowatermark.service;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * <p>项目文档： TODO</p>
 *
 * @author liming
 * @version 1.0.0
 * @createTime 2022年02月18日 20:56:00
 */
@Service
public class PictureService {
    private static final String savePath = "/usr/App/dist";

    public String jpgToGifPicture(MultipartFile file) throws IOException {
        // 通过FileUtil生成一个File对象，用来保存微信上传的图片
        File originFile = FileUtil.file(savePath +  File.separator + file.getOriginalFilename());
        // 将微信图片拷贝到生成的File对象
        FileUtils.copyInputStreamToFile(file.getInputStream(), originFile);
        // 使用UUID生成一个文件名，并且后缀名改为.gif
        String fileName = File.separator + UUID.randomUUID().toString() + ".gif";
        // 转换文件的格式，从jpg转换到gif
        ImgUtil.convert(originFile, FileUtil.file(savePath + fileName));

        return "http://182.92.176.32:9876" + fileName;
    }
}
