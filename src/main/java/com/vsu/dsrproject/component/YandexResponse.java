package com.vsu.dsrproject.component;


import java.util.ArrayList;
import java.util.List;

public class YandexResponse {
    private Integer code;
    private String lang;
    private List<String> text = new ArrayList<>();
    private List<String> inputText = new ArrayList<>();
    private List<String> outputText = new ArrayList<>();

    public List<String> getInputText() {
        return inputText;
    }

    public void setInputText(List<String> inputText) {
        this.inputText = inputText;
    }

    public List<String> getOutputText() {
        return outputText;
    }

    public void setOutputText(List<String> outputText) {
        this.outputText = outputText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof YandexResponse)) return false;

        YandexResponse that = (YandexResponse) o;

        if (getCode() != null ? !getCode().equals(that.getCode()) : that.getCode() != null) return false;
        if (getLang() != null ? !getLang().equals(that.getLang()) : that.getLang() != null) return false;
        return getText() != null ? getText().equals(that.getText()) : that.getText() == null;

    }

    @Override
    public int hashCode() {
        int result = getCode() != null ? getCode().hashCode() : 0;
        result = 31 * result + (getLang() != null ? getLang().hashCode() : 0);
        result = 31 * result + (getText() != null ? getText().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "YandexResponse{" +
                "code=" + code +
                ", lang='" + lang + '\'' +
                ", text=" + text +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }
}
