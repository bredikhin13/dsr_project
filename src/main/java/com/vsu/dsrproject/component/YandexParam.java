package com.vsu.dsrproject.component;


public class YandexParam {
    final String key = "trnsl.1.1.20161212T223910Z.433ead13e4be01e1.7dd9a32b56ac2768fe6ca92e9db4020c50ddaeef";

    @Override
    public String toString() {
        return "YandexParam{" +
                "key='" + key + '\'' +
                ", text='" + text + '\'' +
                ", lang='" + lang + '\'' +
                ", format='" + format + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof YandexParam)) return false;

        YandexParam that = (YandexParam) o;

        if (getKey() != null ? !getKey().equals(that.getKey()) : that.getKey() != null) return false;
        if (getText() != null ? !getText().equals(that.getText()) : that.getText() != null) return false;
        if (getLang() != null ? !getLang().equals(that.getLang()) : that.getLang() != null) return false;
        return getFormat() != null ? getFormat().equals(that.getFormat()) : that.getFormat() == null;

    }

    @Override
    public int hashCode() {
        int result = getKey() != null ? getKey().hashCode() : 0;
        result = 31 * result + (getText() != null ? getText().hashCode() : 0);
        result = 31 * result + (getLang() != null ? getLang().hashCode() : 0);
        result = 31 * result + (getFormat() != null ? getFormat().hashCode() : 0);
        return result;
    }

    public String getKey() {

        return key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    private String text;
    private String lang;
    private String format;


}
