package com.example.score.dto;

import lombok.Data;

@Data
public class ClassSummary {
    private String className;
    private Integer studentCount;
    private Double averageScore;
    private Double maxScore;
    private Double minScore;
}
