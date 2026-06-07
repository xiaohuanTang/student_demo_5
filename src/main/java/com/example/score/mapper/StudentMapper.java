package com.example.score.mapper;

import com.example.score.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("SELECT * FROM student ORDER BY id DESC")
    List<Student> findAll();

    @Select("SELECT * FROM student WHERE id = #{id}")
    Student findById(Long id);

    @Insert("INSERT INTO student(student_no, name, gender, age, class_name) VALUES(#{studentNo}, #{name}, #{gender}, #{age}, #{className})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Student student);

    @Update("UPDATE student SET student_no=#{studentNo}, name=#{name}, gender=#{gender}, age=#{age}, class_name=#{className} WHERE id=#{id}")
    int update(Student student);

    @Delete("DELETE FROM student WHERE id = #{id}")
    int delete(Long id);
}
