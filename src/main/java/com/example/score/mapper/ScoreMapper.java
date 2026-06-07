package com.example.score.mapper;

import com.example.score.dto.ScoreView;
import com.example.score.model.Score;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ScoreMapper {
    @Select("""
            SELECT sc.id, s.student_no, s.name AS student_name, s.class_name,
                   c.course_name, sc.score, sc.exam_date
            FROM score sc
            JOIN student s ON sc.student_id = s.id
            JOIN course c ON sc.course_id = c.id
            ORDER BY sc.id DESC
            """)
    List<ScoreView> findAllView();

    @Select("SELECT * FROM score WHERE id = #{id}")
    Score findById(Long id);

    @Insert("INSERT INTO score(student_id, course_id, score, exam_date) VALUES(#{studentId}, #{courseId}, #{score}, #{examDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Score score);

    @Update("UPDATE score SET student_id=#{studentId}, course_id=#{courseId}, score=#{score}, exam_date=#{examDate} WHERE id=#{id}")
    int update(Score score);

    @Delete("DELETE FROM score WHERE id = #{id}")
    int delete(Long id);
}
