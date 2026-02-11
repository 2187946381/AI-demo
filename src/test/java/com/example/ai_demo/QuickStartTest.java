package com.example.ai_demo;

import com.example.ai_demo.controller.ContentController;
import com.example.ai_demo.dto.OcrContent;
import com.example.ai_demo.dto.User;
import com.example.ai_demo.mapper.OcrContentMapper;
import com.example.ai_demo.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@SpringBootTest
public class QuickStartTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OcrContentMapper ocrContentMapper;

    @Autowired
    private ContentController contentController;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        // 结果存入userList列表
        List<User> userList = userMapper.selectList(null);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectOcr() {   // 查找测试
        System.out.println(("----- selectAll method test ------"));
        // 结果存入userList列表
        List<OcrContent> ocrContentList = ocrContentMapper.selectList(null);
        for (OcrContent ocrContent : ocrContentList) {
            System.out.println(ocrContent);
        }
    }

    @Test
    public void testInsertOcr() {   // 插入测试
        System.out.println(("----- insert method test ------"));
        // 创建一个插入项
        OcrContent insertContent = new OcrContent();
        insertContent.setId(2);
        insertContent.setType(1);
        insertContent.setContent("你好世界");
        insertContent.setCreateTime(new Date());
        insertContent.setModifyTime(new Date());
        ocrContentMapper.insert(insertContent);
    }

    @Test
    public void testDeleteOcr() {   // 删除测试
        System.out.println(("----- delete method test ------"));
        ocrContentMapper.deleteById(2);
    }

    @Test
    public void testUpdateOcr() {   // 更新测试
        System.out.println(("----- update method test ------"));
        // 创建一个更新项
        OcrContent updateContent = new OcrContent();
        updateContent.setId(1);
        updateContent.setType(1);
        updateContent.setContent("你好世界");
        updateContent.setCreateTime(new Date());
        updateContent.setModifyTime(new Date());
        ocrContentMapper.updateById(updateContent);
    }

    @Test
    public void testContentController(){
        System.out.println(("----- contentController method test ------"));
        List<OcrContent> ocrContents = contentController.getAllContent();
        System.out.println(ocrContents);
    }

    @Test
    public void test1(){
        System.out.println(TimeZone.getDefault().getID());
        System.out.println(new Date());
        System.out.println(LocalDateTime.now());
    }

}
