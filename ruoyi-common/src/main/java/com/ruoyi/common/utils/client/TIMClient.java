package com.ruoyi.common.utils.client;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.TLSSigAPIv2;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class TIMClient {
    static final RestTemplate restTemplate;
    static final TLSSigAPIv2 SIG_GENERATOR;
    static final long SDK_APP_ID = 1400637187;
    static final String DEFAULT_ADMIN_ACCOUNT_ID = "administrator";
    static final String PRIVATE_KEY = "f2b1f13dd36836d7199c80022566f84e6756b5dd423bb54e7f3914e0f267343c";

    static {
        restTemplate = new RestTemplateBuilder()
                .build();

        SIG_GENERATOR = new TLSSigAPIv2(SDK_APP_ID, PRIVATE_KEY);
    }

    public TIMClient() {
    }

    public static String getUserSig(String userId) {
        return SIG_GENERATOR.genUserSig(userId, 3600);
    }

    public <T> ResponseEntity<T> sendRequest(String serviceName, String command, String userIdentifier, JSONObject requestBody, Class<T> responseType) {
        String identifier = userIdentifier == null ? DEFAULT_ADMIN_ACCOUNT_ID : userIdentifier;
        String userSig = SIG_GENERATOR.genUserSig(identifier, 60);
        String url = String.format("https://console.tim.qq.com/v4/%s/%s?sdkappid=%s&identifier=%s&usersig=%s&random=42&contenttype=json",
                serviceName,
                command,
                SDK_APP_ID,
                userIdentifier == null ? DEFAULT_ADMIN_ACCOUNT_ID : userIdentifier,
                userSig
        );

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody.toString());
        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, responseType);
    }
}
