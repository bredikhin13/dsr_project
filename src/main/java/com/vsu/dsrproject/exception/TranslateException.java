package com.vsu.dsrproject.exception;


import org.springframework.validation.BindingResult;

public class TranslateException extends Exception {

    public TranslateException(String message) {
        super(message);
    }


}
