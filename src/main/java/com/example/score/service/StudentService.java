package com.example.score.service;

import com.example.score.mapper.StudentMapper;
import com.example.score.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentMapper studentMapper;

    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    public Student findById(Long id) {
        Student student = studentMapper.findById(id);
        if (student == null) {
            throw new IllegalArgumentException("学生不存在：id=" + id);
        }
        return student;
    }

    public Student create(Student student) {
        studentMapper.insert(student);
        return student;
    }

    public void update(Long id, Student student) {
        findById(id);
        student.setId(id);
        studentMapper.update(student);
    }

    public void delete(Long id) {
        findById(id);
        studentMapper.delete(id);
    }
}
