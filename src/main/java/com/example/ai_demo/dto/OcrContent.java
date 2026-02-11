package com.example.ai_demo.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("`ocr_content`")     // 指定数据库的表名
public class OcrContent {
    @TableId(type = IdType.AUTO)    // id自增
    private Integer id;

    private String content;
    private Integer type;
    // 使用驼峰命名法
    private Date createTime;
    private Date modifyTime;
}
