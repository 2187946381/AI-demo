package com.example.ai_demo.util;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashMap;

public class AiUtils {
    /** NLP
     *
     * @param text
     * @return 纠错后的语句
     */
    public static String nlp(String text){
        //设置APPID/AK/SK
        String APP_ID = "";
        String API_KEY = "";
        String SECRET_KEY = "";
        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);
        // 调用接口
        JSONObject res = client.ecnet(text, null);
        // System.out.println(res.toString(2));
        String res1 = res.getJSONObject("item").getString("correct_query");
        return res1;
    }

    /** 图像识别
     * @param file
     * @return 图像识别的最佳结果
     */
    public static String img(MultipartFile file) throws IOException {
        //设置APPID/AK/SK
        String APP_ID = "";
        String API_KEY = "";
        String SECRET_KEY = "";
        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
        // 调用接口
        JSONObject res = client.advancedGeneral(file.getBytes(), new HashMap<String, String>());
        // System.out.println(res.toString(2));
        // 输出概率最大的识别结果
        JSONObject result = res.getJSONArray("result").getJSONObject(0);
        String s = "这张图有 " + result.getDouble("score")*100 + "% 的可能是 " + result.getString("keyword");
        return s;
    }

    /** 文字识别
     *
     * @return
     */
    public static String word(MultipartFile file) throws IOException {
        //设置APPID/AK/SK
        String APP_ID = "";
        String API_KEY = "";
        String SECRET_KEY = "";
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 调用接口
        JSONObject res = client.basicGeneral(file.getBytes(), new HashMap<String, String>());
        //System.out.println(res.toString(2));
        JSONArray result = res.getJSONArray("words_result");
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < result.length(); i++){
            s.append(result.getJSONObject(i).getString("words"))
                    .append("\n");
        }
        return s.toString();
    }

    // 测试
    public static void main(String[] args) {
        String text = "百度是一加高科技工司";
        System.out.println(nlp(text));
    }
}
