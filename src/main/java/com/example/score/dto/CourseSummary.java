package com.example.score.dto;

import lombok.Data;

@Data
public class CourseSummary {
    private Long courseId;
    private String courseName;
    private Integer studentCount;
    private Double averageScore;
    private Double maxScore;
    private Double minScore;
    private Double passRate;
}
