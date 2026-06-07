package com.example.score.dto;

import lombok.Data;

@Data
public class StudentSummary {
    private Long studentId;
    private String studentNo;
    private String studentName;
    private String className;
    private Integer courseCount;
    private Double totalScore;
    private Double averageScore;
    private Integer rankNo;
}
