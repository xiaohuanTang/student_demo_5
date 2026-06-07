package com.example.score.service;

import com.example.score.mapper.CourseMapper;
import com.example.score.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseMapper courseMapper;

    public CourseService(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    public List<Course> findAll() {
        return courseMapper.findAll();
    }

    public Course findById(Long id) {
        Course course = courseMapper.findById(id);
        if (course == null) {
            throw new IllegalArgumentException("课程不存在：id=" + id);
        }
        return course;
    }

    public Course create(Course course) {
        courseMapper.insert(course);
        return course;
    }

    public void update(Long id, Course course) {
        findById(id);
        course.setId(id);
        courseMapper.update(course);
    }

    public void delete(Long id) {
        findById(id);
        courseMapper.delete(id);
    }
}
