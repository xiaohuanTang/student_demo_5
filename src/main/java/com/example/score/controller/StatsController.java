package com.example.score.controller;

import com.example.score.dto.ClassSummary;
import com.example.score.dto.CourseSummary;
import com.example.score.dto.StudentSummary;
import com.example.score.service.StatsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stats")
public class StatsController {
    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/students")
    public List<StudentSummary> studentRank() {
        return statsService.studentRank();
    }

    @GetMapping("/courses")
    public List<CourseSummary> courseSummary() {
        return statsService.courseSummary();
    }

    @GetMapping("/classes")
    public List<ClassSummary> classSummary() {
        return statsService.classSummary();
    }
}
