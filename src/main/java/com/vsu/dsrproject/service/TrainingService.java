package com.vsu.dsrproject.service;

import com.vsu.dsrproject.data.WordTrueCountComparator;
import com.vsu.dsrproject.dto.TrainingDto;
import com.vsu.dsrproject.dto.TrainingNameDto;
import com.vsu.dsrproject.entity.Training;
import com.vsu.dsrproject.entity.Word;
import com.vsu.dsrproject.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

@Service
public class TrainingService {

    @Autowired
    WordService wordService;

    @Autowired
    TrainingRepository trainingRepository;

    @Transactional
    public Training getRandomTraining() {
        List<Word> words = wordService.getAll();
        Set<Word> wordSet = new HashSet<>();
        Random random = new Random();
        Training training = getOneByName("Random");
        while (wordSet.size() < 10) {
            wordSet.add(words.remove(random.nextInt(words.size())));
        }
        training.setFakeWords(words);
        training.setWords(wordSet);
        return training;
    }

    @Transactional
    public Training getHardTraining() {
        List<Word> words = wordService.getAll();
        Set<Word> wordSet = new HashSet<>();
        words.sort(new WordTrueCountComparator());
        Training training = getOneByName("Hard");
        int count = 0;
        while (wordSet.size() < 10) {
            wordSet.add(words.remove(count++));
        }
        training.setFakeWords(words);
        training.setWords(wordSet);
        return training;
    }

    @Transactional
    public List<Training> getAll(){
        return stream(trainingRepository.findAll().spliterator(), false)
                .collect(toList());
    }


    @Transactional
    public Training getOneByName(String name){
        return trainingRepository.findByName(name);
    }

    @Transactional
    public Training update(TrainingDto training){
        Training savedTraining = trainingRepository.findOne(training.getId());
        savedTraining.setWorstResult(training.getWorstResult());
        savedTraining.setBestResult(training.getBestResult());
        savedTraining.setCallCount(training.getCallCount());
        savedTraining.setPoints(training.getPoints());
       return trainingRepository.save(savedTraining);
    }

    @Transactional
    public Training create(TrainingNameDto dto){
        Training training = new Training();
        training.setName(dto.getName());
        Set<Word> words = new HashSet<>();
        for(Long id:dto.getWords()){
            words.add(wordService.getOne(id));
        }
        training.setWords(words);
        training.setCallCount(0);
        training.setCallCount(0);
        training.setBestResult(0);
        training.setPoints(0);
        training.setWorstResult(words.size());
        return trainingRepository.save(training);
    }

    @Transactional
    public List<Training> getAllCustomTrainings(){
        List<Training> trainings = (List<Training>) trainingRepository.findAll();
        trainings.remove(0);
        trainings.remove(1);
        return trainings;
    }

    @Transactional
    public Training getOneCustomTraining(Long id){
        Training training = trainingRepository.findOne(id);
        List<Word> words = wordService.getAll();
        for(Word word: training.getWords()){
            words.remove(word);
        }
        training.setFakeWords(words);
        return training;
    }
}



