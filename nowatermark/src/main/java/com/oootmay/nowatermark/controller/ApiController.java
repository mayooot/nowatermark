package com.oootmay.nowatermark.controller;


import cn.hutool.core.thread.ThreadUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.oootmay.nowatermark.result.BareResult;
import com.oootmay.nowatermark.service.BareService;
import com.oootmay.nowatermark.service.PictureService;
import com.oootmay.nowatermark.utils.DownloadUtil;
import com.oootmay.nowatermark.utils.ResponseUtil;
import com.oootmay.nowatermark.utils.ReturnObject;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * <p>项目文档： TODO</p>
 *
 * @author liming
 * @version 1.0.0
 * @createTime 2022年01月31日 22:36:00
 */
@Api(tags = "短视频/图片去水印; 图片格式转换")
@RestController
public class ApiController {
    @Resource
    private BareService bareService;

    @Resource
    private PictureService pictureService;

    /**
     * 下载接口，后端会将无水印作品先下载到本地服务器，然后返回本地服务器上的作品url
     * @param url 用户分享的链接
     * @return 无水印的作品信息集合
     */
    @PostMapping("/bare")
    private ReturnObject<BareResult> bare(@RequestBody String url) throws Exception{
        return ResponseUtil.ok(bareService.parse(url));
    }

    @RequestMapping("/picture")
    public String pictureFormat(MultipartFile file) throws Exception {
        ThreadUtil.sleep(3000);
       return pictureService.jpgToGifPicture(file);
    }

    /**
     * 当用户下载完视频后，一分钟后删除服务器上的文件
     * @param path 文件的完整路径，需要再次split，前端split之后的path没有办法传进来 - -
     */
    @PostMapping("/delete")
    private void delete(@RequestBody String path) throws InterruptedException {
        JSONObject jsonObject = JSON.parseObject(path);
        String originPath = jsonObject.getString("path");
        System.out.println(originPath);
        DownloadUtil.deleteFromPath(originPath);
    }

}
