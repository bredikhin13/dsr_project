package com.vsu.dsrproject.service;

import com.vsu.dsrproject.entity.Word;
import com.vsu.dsrproject.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.transaction.TransactionScoped;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;


@Service
public class WordService {

    @Autowired
    private WordRepository wordRepository;

    @Transactional
    public List<Word> getAll() {
        return stream(wordRepository.findAll().spliterator(), false)
                .collect(toList());
    }

    @Transactional
    public void saveAll(Set<Word> words){
       wordRepository.save(words);
    }

    @Transactional
    public Word update(Word word){
        Word savedWord = wordRepository.findOne(word.getId());
        savedWord.setCallCount(word.getCallCount());
        savedWord.setTrueCount(word.getTrueCount());
        return wordRepository.save(savedWord);
    }

    @Transactional
    public Word getOne(Long id){
        return wordRepository.findOne(id);
    }

}
