package com.vsu.dsrproject.component;

import com.vsu.dsrproject.app.Launcher;
import com.vsu.dsrproject.entity.Language;
import com.vsu.dsrproject.entity.Word;
import com.vsu.dsrproject.repository.LanguageRepository;
import com.vsu.dsrproject.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
public class DbInit {
    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @PostConstruct
    @Transactional
    public void init(){
        Language languageRu = new Language();
        languageRu.setName("Russian");
        languageRu.setCode("RU");
        languageRepository.save(languageRu);

        Language languageEn = new Language();
        languageRu.setName("English");
        languageRu.setCode("EN");
        languageRepository.save(languageEn);

        Word word = new Word();
        word.setWord("голова");
        word.setLanguage(languageRu);
        word.setTranslate("head");
        word.setCallCount(0);
        word.setTrueCount(0);
        wordRepository.save(word);
    }
}
