package com.example.score.controller;

import com.example.score.model.Student;
import com.example.score.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> list() {
        return studentService.findAll();
    }

    @PostMapping
    public Student create(@Valid @RequestBody Student student) {
        return studentService.create(student);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody Student student) {
        studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}
