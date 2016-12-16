package com.vsu.dsrproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler{

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e,
                                   ModelMap modelMap) {
        modelMap.addAttribute("error", e.getMessage());
        return "error";
    }

}
