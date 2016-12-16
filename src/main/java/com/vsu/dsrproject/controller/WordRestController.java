package com.vsu.dsrproject.controller;

import com.vsu.dsrproject.component.PairWords;
import com.vsu.dsrproject.component.YandexResponse;
import com.vsu.dsrproject.component.YandexTranslate;
import com.vsu.dsrproject.entity.Word;
import com.vsu.dsrproject.service.TextParser;
import com.vsu.dsrproject.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/word")
public class WordRestController {

    @Autowired
    private WordService wordService;

    @Autowired
    private YandexTranslate yandexTranslate;

    @RequestMapping(value = "/load", method = RequestMethod.POST, params = "text")
    @ResponseBody
    public YandexResponse translate(String text) {
        return yandexTranslate.getRsp(text);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity saveToDb(@RequestBody List<PairWords> data) {
        TextParser parser = new TextParser();
        wordService.saveAll(parser.createListWords(data));
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Word getWord(@RequestBody Word word) {
        return wordService.update(word);
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    @ResponseBody
    public List<Word> getAll() {
        List<Word> words = wordService.getAll();
        return words;
    }
}
