package com.example.score.service;

import com.example.score.dto.ClassSummary;
import com.example.score.dto.CourseSummary;
import com.example.score.dto.StudentSummary;
import com.example.score.mapper.StatsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsService {
    private final StatsMapper statsMapper;

    public StatsService(StatsMapper statsMapper) {
        this.statsMapper = statsMapper;
    }

    public List<StudentSummary> studentRank() {
        return statsMapper.studentRank();
    }

    public List<CourseSummary> courseSummary() {
        return statsMapper.courseSummary();
    }

    public List<ClassSummary> classSummary() {
        return statsMapper.classSummary();
    }
}
