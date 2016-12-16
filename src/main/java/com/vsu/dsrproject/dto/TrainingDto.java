package com.vsu.dsrproject.dto;

/**
 * Created by Pavel on 16.12.2016.
 */
public class TrainingDto {
    private Long id;
    private Integer callCount;
    private Integer points;
    private Integer bestResult;
    private Integer worstResult;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
