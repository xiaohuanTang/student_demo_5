package com.example.score.service;

import com.example.score.dto.ScoreView;
import com.example.score.mapper.CourseMapper;
import com.example.score.mapper.ScoreMapper;
import com.example.score.mapper.StudentMapper;
import com.example.score.model.Score;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    private final ScoreMapper scoreMapper;
    private final StudentMapper studentMapper;
    private final CourseMapper courseMapper;

    public ScoreService(ScoreMapper scoreMapper, StudentMapper studentMapper, CourseMapper courseMapper) {
        this.scoreMapper = scoreMapper;
        this.studentMapper = studentMapper;
        this.courseMapper = courseMapper;
    }

    public List<ScoreView> findAllView() {
        return scoreMapper.findAllView();
    }

    public Score create(Score score) {
        checkForeignKeys(score);
        scoreMapper.insert(score);
        return score;
    }

    public void update(Long id, Score score) {
        if (scoreMapper.findById(id) == null) {
            throw new IllegalArgumentException("成绩记录不存在：id=" + id);
        }
        checkForeignKeys(score);
        score.setId(id);
        scoreMapper.update(score);
    }

    public void delete(Long id) {
        if (scoreMapper.findById(id) == null) {
            throw new IllegalArgumentException("成绩记录不存在：id=" + id);
        }
        scoreMapper.delete(id);
    }

    private void checkForeignKeys(Score score) {
        if (studentMapper.findById(score.getStudentId()) == null) {
            throw new IllegalArgumentException("学生不存在：id=" + score.getStudentId());
        }
        if (courseMapper.findById(score.getCourseId()) == null) {
            throw new IllegalArgumentException("课程不存在：id=" + score.getCourseId());
        }
    }
}
