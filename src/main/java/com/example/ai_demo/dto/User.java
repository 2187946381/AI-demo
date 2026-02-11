package com.example.ai_demo.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

// 学习测试使用，实际不调用
@Data
@TableName("`user`")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
