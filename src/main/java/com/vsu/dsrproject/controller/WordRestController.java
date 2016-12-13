package com.vsu.dsrproject.controller;

import com.vsu.dsrproject.component.YandexResponse;
import com.vsu.dsrproject.component.YandexTranslate;
import com.vsu.dsrproject.entity.Word;
import com.vsu.dsrproject.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/word")
public class WordRestController {

    @Autowired
    private WordService wordService;

    @RequestMapping(value = "/load",method = RequestMethod.POST,params = "text")
    @ResponseBody
    public YandexResponse translate(String text){
        return YandexTranslate.getRsp(text);
    }
}
