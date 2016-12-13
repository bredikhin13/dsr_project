package com.vsu.dsrproject.controller;

import com.vsu.dsrproject.entity.Word;
import com.vsu.dsrproject.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/word")
public class WordController {

    @RequestMapping(value = "", method = GET)
    public String list(ModelMap modelMap) {

        return "word/show";
    }
}
