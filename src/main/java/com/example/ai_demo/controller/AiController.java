package com.example.ai_demo.controller;

import com.example.ai_demo.dto.OcrContent;
import com.example.ai_demo.mapper.OcrContentMapper;
import com.example.ai_demo.util.AiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.OctetStreamData;
import java.io.IOException;
import java.util.Date;

@RestController
public class AiController {
    @Autowired
    private OcrContentMapper ocrContentMapper;

    @RequestMapping(value = "/nlp", method = RequestMethod.GET)
    public String nlp(@RequestParam("text") String text){
        String res = AiUtils.nlp(text);
        // 创建一个插入项
        OcrContent ocrContent = new OcrContent();
        // ocrContent.setId((int) (ocrContentMapper.selectCount(null) + 1));
        ocrContent.setType(1);
        ocrContent.setContent(res);
        System.out.println(new Date());
        ocrContent.setCreateTime(new Date());
        ocrContent.setModifyTime(new Date());
        // 保存到表中
        ocrContentMapper.insert(ocrContent);
        return res;
    }

    @RequestMapping(value = "/img", method = RequestMethod.POST)
    public String img(@RequestParam("file") MultipartFile file) throws IOException {
        String res = AiUtils.img(file);
        // 创建一个插入项
        OcrContent ocrContent = new OcrContent();
        ocrContent.setType(2);
        ocrContent.setContent(res);
        ocrContent.setCreateTime(new Date());
        ocrContent.setModifyTime(new Date());
        // 保存到表中
        ocrContentMapper.insert(ocrContent);
        return res;
    }

    @RequestMapping(value = "/word", method = RequestMethod.POST)
    public String word(@RequestParam("file") MultipartFile file) throws IOException {
        String res = AiUtils.word(file);
        // 创建一个插入项
        OcrContent ocrContent = new OcrContent();
        ocrContent.setType(3);
        ocrContent.setContent(res);
        ocrContent.setCreateTime(new Date());
        ocrContent.setModifyTime(new Date());
        // 保存到表中
        ocrContentMapper.insert(ocrContent);
        return res;
    }
}
