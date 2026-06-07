package com.example.score.controller;

import com.example.score.model.Course;
import com.example.score.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> list() {
        return courseService.findAll();
    }

    @PostMapping
    public Course create(@Valid @RequestBody Course course) {
        return courseService.create(course);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody Course course) {
        courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        courseService.delete(id);
    }
}
