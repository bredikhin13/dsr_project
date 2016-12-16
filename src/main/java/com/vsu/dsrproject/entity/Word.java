package com.vsu.dsrproject.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String word;


    private String translate;
    private Integer callCount;
    private Integer trueCount;

    //@ManyToOne
    //@JoinColumn(name = "languageId")
    private String language;


    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "words")
    private Set<Training> trainings = new HashSet<Training>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;

        Word word1 = (Word) o;

        if (getId() != null ? !getId().equals(word1.getId()) : word1.getId() != null) return false;
        if (getWord() != null ? !getWord().equals(word1.getWord()) : word1.getWord() != null) return false;
        if (getTranslate() != null ? !getTranslate().equals(word1.getTranslate()) : word1.getTranslate() != null)
            return false;
        if (getCallCount() != null ? !getCallCount().equals(word1.getCallCount()) : word1.getCallCount() != null)
            return false;
        if (getTrueCount() != null ? !getTrueCount().equals(word1.getTrueCount()) : word1.getTrueCount() != null)
            return false;
        return getLanguage() != null ? getLanguage().equals(word1.getLanguage()) : word1.getLanguage() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getWord() != null ? getWord().hashCode() : 0);
        result = 31 * result + (getTranslate() != null ? getTranslate().hashCode() : 0);
        result = 31 * result + (getCallCount() != null ? getCallCount().hashCode() : 0);
        result = 31 * result + (getTrueCount() != null ? getTrueCount().hashCode() : 0);
        result = 31 * result + (getLanguage() != null ? getLanguage().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", translate='" + translate + '\'' +
                ", callCount=" + callCount +
                ", trueCount=" + trueCount +
                ", language=" + language +
                '}';
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public Integer getCallCount() {
        return callCount;
    }

    public void setCallCount(Integer callCount) {
        this.callCount = callCount;
    }

    public Integer getTrueCount() {
        return trueCount;
    }

    public void setTrueCount(Integer trueCount) {
        this.trueCount = trueCount;
    }

    public String getLanguage() {

        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Set<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(Set<Training> trainings) {
        this.trainings = trainings;
    }


}
