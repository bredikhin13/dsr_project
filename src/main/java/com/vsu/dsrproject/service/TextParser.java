package com.vsu.dsrproject.service;


import com.vsu.dsrproject.component.PairWords;
import com.vsu.dsrproject.data.Languages;
import com.vsu.dsrproject.entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class TextParser {

    @Autowired
    private WordService wordService;

    public String parseInputText(String text){
        String s1 = text.replaceAll("[^a-zA-Z\\s]+","");
        String s2 = s1.replaceAll("[\\s]{1,}", ". ");
        return s2;
    }

    public Set<Word> createListWords(List<PairWords> pairWordses){
        Set<Word> words = new HashSet<>();
        Word word = new Word();
        for(PairWords pairWords : pairWordses){
            if(pairWords.getName().equals("word")){
                word = new Word();
                word.setWord(pairWords.getValue());
            }
            if(pairWords.getName().equals("translate")){
                word.setTranslate(pairWords.getValue());
                word.setTrueCount(0);
                word.setCallCount(0);
                word.setLanguage(Languages.languageRu.getCode());
                words.add(word);
            }
        }
        return words;
    }
}
