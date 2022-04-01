package com.ruoyi.common.utils.client;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;

public class TIMClinetTest {
    public static void main(String[] args) {
        JSONObject params = new JSONObject();
        params.put("UserID", "test");
        ResponseEntity<JSONObject> result = TIMClient.sendRequest("im_open_login_svc", "account_import", null, params, JSONObject.class);
        System.out.println("result = " + result);
    }
}
