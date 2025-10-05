package com.example.FeedbackFy.dto;

import java.util.Map;

public class FeedbackStatsResponse {
    private Integer totalFeedbacks;
    private Map<String, Integer> porTipo;

    public FeedbackStatsResponse() {
    }

    public FeedbackStatsResponse(Integer totalFeedbacks, Map<String, Integer> porTipo) {
        this.totalFeedbacks = totalFeedbacks;
        this.porTipo = porTipo;
    }

    public Integer getTotalFeedbacks() {
        return totalFeedbacks;
    }

    public void setTotalFeedbacks(Integer totalFeedbacks) {
        this.totalFeedbacks = totalFeedbacks;
    }

    public Map<String, Integer> getPorTipo() {
        return porTipo;
    }

    public void setPorTipo(Map<String, Integer> porTipo) {
        this.porTipo = porTipo;
    }
}
