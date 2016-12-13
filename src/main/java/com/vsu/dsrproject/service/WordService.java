package com.vsu.dsrproject.service;

import com.vsu.dsrproject.entity.Word;
import com.vsu.dsrproject.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

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
}
