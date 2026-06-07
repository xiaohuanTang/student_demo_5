package com.example.score.model;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Student {
    private Long id;

    @NotBlank(message = "学号不能为空")
    private String studentNo;

    @NotBlank(message = "姓名不能为空")
    private String name;

    @NotBlank(message = "性别不能为空")
    private String gender;

    @Min(value = 1, message = "年龄必须大于0")
    @Max(value = 100, message = "年龄不能超过100")
    private Integer age;

    @NotBlank(message = "班级不能为空")
    private String className;

    private LocalDateTime createdAt;
}
