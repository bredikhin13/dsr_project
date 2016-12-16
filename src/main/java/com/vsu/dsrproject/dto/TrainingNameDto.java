package com.vsu.dsrproject.dto;


import java.util.List;

public class TrainingNameDto {
    private String name;
    private List<Long> words;
//    private Long id;
//
//    public TrainingNameDto(){}
//
//    public TrainingNameDto(Long id, String name){
//        this.name = name;
//        this.id = id;
//    }
//    public TrainingNameDto(String name, List<Long> id){
//        this.name = name;
//        this.words = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getWords() {
        return words;
    }

    public void setWords(List<Long> words) {
        this.words = words;
    }
}
