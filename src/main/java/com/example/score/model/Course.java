package com.example.score.model;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class Course {
    private Long id;

    @NotBlank(message = "课程名称不能为空")
    private String courseName;

    @NotBlank(message = "任课教师不能为空")
    private String teacher;

    @DecimalMin(value = "0.5", message = "学分不能小于0.5")
    @DecimalMax(value = "10.0", message = "学分不能大于10")
    private Double credit;
}
