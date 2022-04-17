package com.ruoyi.web.controller;
// 小程序接口

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/mini")


public class MiniController {


    @Value("${mini.appid}")
    private String appid;

    @Value("${mini.secret}")
    private  String secret;




    // 微信小程序登录
    @GetMapping("/login")
    public AjaxResult login(String code) throws IOException {
//        if(StringUtils.isEmpty(code)) {
//            return Result.fail("登录失败，请联系管理员！");
//        }

        // 创建一个client请求
        CloseableHttpClient client = HttpClientBuilder.create().build();

        // 构建一个Get请求
        String url = "https://api.weixin.qq.com/sns/jscode2session?" + "appid=" +
                appid +
                "&secret=" +
                secret +
                "&js_code=" +
                code +
                "&grant_type=authorization_code";
        HttpGet get = new HttpGet(url);

        // 发送请求
        CloseableHttpResponse response = client.execute(get);
//        log.info("请求响应码：{}",response.getStatusLine().getStatusCode());
        String result = EntityUtils.toString(response.getEntity());
//        log.info("请求响应结果：-->{}",result);

        JSONObject jsonObject = JSON.parseObject(result);
        String openid = jsonObject.getString("openid");
        String token = jsonObject.getString("token");
//        log.info("微信小程序唯一标识：{}",openid);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("openid",openid);
        ajax.put("token",token);
        return ajax;






   }



}
