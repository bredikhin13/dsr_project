package com.vsu.dsrproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StatisticController {

    @RequestMapping(value = "/statistic", method = RequestMethod.GET)
    public String open(){
        return "statistic/statistic";
    }
}
