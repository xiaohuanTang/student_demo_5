package com.example.score.model;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Score {
    private Long id;

    @NotNull(message = "学生ID不能为空")
    private Long studentId;

    @NotNull(message = "课程ID不能为空")
    private Long courseId;

    @DecimalMin(value = "0.0", message = "成绩不能小于0")
    @DecimalMax(value = "100.0", message = "成绩不能大于100")
    private Double score;

    @NotNull(message = "考试日期不能为空")
    private LocalDate examDate;
}
