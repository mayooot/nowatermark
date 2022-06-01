package com.oootmay.nowatermark.utils;

import cn.hutool.core.lang.UUID;
import com.oootmay.nowatermark.parse.Platform;
import com.oootmay.nowatermark.parse.enums.MediaType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * <p>项目文档： 资源下载的工具类</p>
 *
 * @author liming
 * @version 1.0.0
 * @createTime 2022年02月05日 18:32:00
 */
public class DownloadUtil {
    private static final String downloadPath = "/usr/App/dist";
    // private static final String downloadPath = "C:\\Users\\86183\\Desktop\\watermark\\watermark-demo\\vue\\dist";
    // private static final String downloadPath = "E:\\develop\\code\\去水印代码参考\\watermark\\watermark-demo\\vue\\dist";
    private static final String vedioExtension = ".mp4";
    private static final String imageExtension = ".jpg";

    public static void main(String[] args) throws Exception {
        downLoadFromUrl("https://p26-sign.douyinpic.com/tos-cn-i-0813/b96ee37719b0497d8511a441de02510f~noop.webp?x-expires=1646744400&x-signature=B4pl45%2BD3jJVw4uqeQkIbHLv8ls%3D&from=4257465056&s=PackSourceEnum_DOUYIN_REFLOW&se=false&sh=&sc=&l=202202062102320102120380850305A88E&biz_tag=aweme_images",
                "1.jpg", downloadPath);
    }

    public static String download(String url, MediaType mediaType, Platform platform) throws Exception {
        UUID fileName = UUID.randomUUID();
        String downloadUrl = url;
        if (mediaType.getName().equals("视频")) {
            // if (platform.getName().equals("抖音")) {
            //     // 如果是抖音平台的，则需要将网址转化为可下载的网址
            //     downloadUrl = DownloadUtil.parseUrl(url);
            // }
            downLoadFromUrl(downloadUrl, fileName + vedioExtension, downloadPath);
            return "http://182.92.176.32:9876/" + fileName + vedioExtension;
        } else {
            downLoadFromUrl(url, fileName + imageExtension, downloadPath);
            return "http://182.92.176.32:9876/" + fileName + imageExtension;
        }
    }

    /**
     * 将不可以跨域的URL转换为可跨域的URL， 目前只有抖音平台需要这个方法
     * @return 可跨域的URL
     */
    public static String parseUrl(String url) throws Exception {
        URL tariff = new URL(url);
        URLConnection c = tariff.openConnection();
        // c.setRequestProperty("User-Agent", " USER AGENT STRING HERE ");
        c.setRequestProperty("User-agent","Mozilla/4.0");
        BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream(),"GB2312"));
        String originUrl = br.readLine();
        System.out.println(originUrl);
        // 获取到的originUrl被a标签包裹，需要获取到href中的链接，使用Jsoup工具来获取
        Document document = Jsoup.parseBodyFragment(originUrl);
        System.out.println(document);
        Element a = document.getElementsByTag("a").get(0);
        return a.attr("href");
    }

    /**
     * 从网络Url中下载文件
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     */
    public static void  downLoadFromUrl(String urlStr, String fileName, String savePath) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3*1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //得到输入流
        InputStream inputStream = conn.getInputStream();
        //获取自己数组
        byte[] getData = readInputStream(inputStream);

        //文件保存位置
        File saveDir = new File(savePath);
        if(!saveDir.exists()){
            saveDir.mkdir();
        }
        File file = new File(saveDir+ File.separator+fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if(fos!=null){
            fos.close();
        }
        if(inputStream!=null){
            inputStream.close();
        }

    }


    /**
     * 从输入流中获取字节数组
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

    public static ReturnObject<Object> deleteFromPath(String originPath) throws InterruptedException {
        Thread.sleep(5000);
        String fileName = originPath.split("9876/")[1];
        boolean flag = false;
        File file = new File(downloadPath + File.separator + fileName);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            flag = file.delete();
        }

        if (!flag) {
            return ResponseUtil.error(444, "删除失败！");
        }

        return ResponseUtil.ok(null);
    }
}
