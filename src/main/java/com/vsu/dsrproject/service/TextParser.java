package com.vsu.dsrproject.service;


public class TextParser {
    public String parseInputText(String text){
        String s1 = text.replaceAll("[^a-zA-Z\\s]+","");
        String s2 = s1.replaceAll("\\s","; ");
        return s2;
    }
}
