package com.example.score.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ScoreView {
    private Long id;
    private String studentNo;
    private String studentName;
    private String className;
    private String courseName;
    private Double score;
    private LocalDate examDate;
}
