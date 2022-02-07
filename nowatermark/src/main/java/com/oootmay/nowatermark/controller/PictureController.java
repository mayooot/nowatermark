package com.oootmay.nowatermark.controller;

import com.oootmay.nowatermark.common.Result;
import com.oootmay.nowatermark.entity.Picture;
import com.oootmay.nowatermark.mapper.PictureMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>项目文档： TODO</p>
 *
 * @author liming
 * @version 1.0.0
 * @createTime 2022年01月30日 11:45:00
 */
@RestController
@RequestMapping("/picture")
public class PictureController {
    @Resource
    private PictureMapper pictureMapper;

    /**
     * 新增图片
     * RequestBody 可以将前端传来的JSON数据转换为Java对象
     * @param picture 图片对象
     * @return 结果
     */
    @PostMapping
    public Result<?> save(@RequestBody Picture picture) {
        pictureMapper.insert(picture);
        return Result.success();
    }
}
