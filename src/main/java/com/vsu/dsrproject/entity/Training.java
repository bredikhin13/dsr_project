package com.vsu.dsrproject.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Training {

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "training_words", joinColumns = {
            @JoinColumn(name = "training_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "word_id",
                    nullable = false, updatable = false)})
    private Set<Word> words = new HashSet<Word>();


    @Transient
    private List<Word> fakeWords;

    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer callCount;
    private Integer points;
    private Integer bestResult;
    private Integer worstResult;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Training)) return false;

        Training training = (Training) o;

        if (getWords() != null ? !getWords().equals(training.getWords()) : training.getWords() != null)
            return false;
        if (getFakeWords() != null ? !getFakeWords().equals(training.getFakeWords()) : training.getFakeWords() != null)
            return false;
        if (getName() != null ? !getName().equals(training.getName()) : training.getName() != null) return false;
        if (getId() != null ? !getId().equals(training.getId()) : training.getId() != null) return false;
        if (getCallCount() != null ? !getCallCount().equals(training.getCallCount()) : training.getCallCount() != null)
            return false;
        if (getPoints() != null ? !getPoints().equals(training.getPoints()) : training.getPoints() != null)
            return false;
        if (getBestResult() != null ? !getBestResult().equals(training.getBestResult()) : training.getBestResult() != null)
            return false;
        return getWorstResult() != null ? getWorstResult().equals(training.getWorstResult()) : training.getWorstResult() == null;

    }

    @Override
    public int hashCode() {
        int result = getWords() != null ? getWords().hashCode() : 0;
        result = 31 * result + (getFakeWords() != null ? getFakeWords().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getCallCount() != null ? getCallCount().hashCode() : 0);
        result = 31 * result + (getPoints() != null ? getPoints().hashCode() : 0);
        result = 31 * result + (getBestResult() != null ? getBestResult().hashCode() : 0);
        result = 31 * result + (getWorstResult() != null ? getWorstResult().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Training{" +
                "words=" + words +
                ", fakeWords=" + fakeWords +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", callCount=" + callCount +
                ", points=" + points +
                ", bestResult=" + bestResult +
                ", worstResult=" + worstResult +
                '}';
    }

    public Set<Word> getWords() {
        return words;
    }

    public void setWords(Set<Word> words) {
        this.words = words;
    }

    public List<Word> getFakeWords() {
        return fakeWords;
    }

    public void setFakeWords(List<Word> fakeWords) {
        this.fakeWords = fakeWords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCallCount() {
        return callCount;
    }

    public void setCallCount(Integer callCount) {
        this.callCount = callCount;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getBestResult() {
        return bestResult;
    }

    public void setBestResult(Integer bestResult) {
        this.bestResult = bestResult;
    }

    public Integer getWorstResult() {
        return worstResult;
    }

    public void setWorstResult(Integer worstResult) {
        this.worstResult = worstResult;
    }
}
