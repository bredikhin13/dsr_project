package com.vsu.dsrproject.component;


import com.vsu.dsrproject.service.TextParser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YandexTranslate {
    public static YandexResponse getRsp(String text) {
        RestTemplate restTemplate = new RestTemplate();
        HttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
        HttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(formHttpMessageConverter);
        converters.add(stringHttpMessageConverter);
        converters.add(jackson2HttpMessageConverter);
        restTemplate.setMessageConverters(converters);
        YandexParam param = new YandexParam();
        TextParser parser = new TextParser();
        text = parser.parseInputText(text);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("text", text);
        param.setFormat("plain");
        param.setLang("en-ru");
        param.setText("hello world");
        String val = "text=hello world";
        YandexResponse response = restTemplate.postForObject("https://translate.yandex.net/api/v1.5/tr.json/translate?lang="+param.getLang()+"&key="+param.getKey(),map,YandexResponse.class);
        response.setOutputText(Arrays.asList(response.getText().get(0).split("; ")));
        response.setInputText(Arrays.asList(text.split("; ")));
        System.out.println(response);
        return response;
    }
}
