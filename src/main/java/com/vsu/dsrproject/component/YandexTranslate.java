package com.vsu.dsrproject.component;


import com.vsu.dsrproject.exception.TranslateException;
import com.vsu.dsrproject.service.TextParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class YandexTranslate {

    @Autowired
    private TextParser textParser;

    public YandexResponse getRsp(String text) {
        RestTemplate restTemplate = new RestTemplate();
        text = textParser.parseInputText(text);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("text", text);
        YandexResponse response = restTemplate.postForObject(YandexParam.URL+YandexParam.LANGUAGE_EN_RU+YandexParam.KEY,map,YandexResponse.class);
        response.setOutputText(Arrays.asList(response.getText().get(0).split("\\.\\s")));
        response.setInputText(Arrays.asList(text.split("\\.\\s")));
        return response;
    }
}
