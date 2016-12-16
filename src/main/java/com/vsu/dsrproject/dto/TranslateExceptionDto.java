package com.vsu.dsrproject.dto;


public class TranslateExceptionDto {
    public TranslateExceptionDto() {

    }

    public TranslateExceptionDto(String m, String c) {
        this.code = c;
        this.msg = m;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
