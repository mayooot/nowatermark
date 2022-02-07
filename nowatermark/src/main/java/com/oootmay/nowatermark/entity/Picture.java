package com.oootmay.nowatermark.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <p>项目文档： TODO</p>
 *
 * @author liming
 * @version 1.0.0
 * @createTime 2022年01月30日 11:40:00
 */
@TableName("picture")
@Data
public class Picture {
    private Integer id;
    private String name;
    private String url;
}
