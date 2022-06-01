package com.oootmay.nowatermark.test;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>项目文档： TODO</p>
 *
 * @author liming
 * @version 1.0.0
 * @createTime 2022年02月15日 20:09:00
 */
@SpringBootTest
public class ImageTest {
    public static void main(String[] args) {
        ImgUtil.convert(FileUtil.file("C:\\Users\\86183\\Desktop\\1.png"), FileUtil.file("C:\\Users\\86183\\Desktop\\2.gif"));
    }
}
