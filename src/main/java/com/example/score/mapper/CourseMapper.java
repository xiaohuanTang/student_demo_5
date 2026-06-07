package com.example.score.mapper;

import com.example.score.model.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Select("SELECT * FROM course ORDER BY id DESC")
    List<Course> findAll();

    @Select("SELECT * FROM course WHERE id = #{id}")
    Course findById(Long id);

    @Insert("INSERT INTO course(course_name, teacher, credit) VALUES(#{courseName}, #{teacher}, #{credit})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Course course);

    @Update("UPDATE course SET course_name=#{courseName}, teacher=#{teacher}, credit=#{credit} WHERE id=#{id}")
    int update(Course course);

    @Delete("DELETE FROM course WHERE id = #{id}")
    int delete(Long id);
}
