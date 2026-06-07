package com.example.score.mapper;

import com.example.score.dto.ClassSummary;
import com.example.score.dto.CourseSummary;
import com.example.score.dto.StudentSummary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StatsMapper {
    @Select("""
            SELECT student_id, student_no, student_name, class_name, course_count,
                   ROUND(total_score, 2) AS total_score,
                   ROUND(average_score, 2) AS average_score,
                   RANK() OVER (ORDER BY average_score DESC) AS rank_no
            FROM (
                SELECT s.id AS student_id, s.student_no, s.name AS student_name, s.class_name,
                       COUNT(sc.id) AS course_count,
                       COALESCE(SUM(sc.score), 0) AS total_score,
                       COALESCE(AVG(sc.score), 0) AS average_score
                FROM student s
                LEFT JOIN score sc ON s.id = sc.student_id
                GROUP BY s.id, s.student_no, s.name, s.class_name
            ) t
            ORDER BY rank_no, student_id
            """)
    List<StudentSummary> studentRank();

    @Select("""
            SELECT c.id AS course_id, c.course_name,
                   COUNT(sc.id) AS student_count,
                   ROUND(AVG(sc.score), 2) AS average_score,
                   MAX(sc.score) AS max_score,
                   MIN(sc.score) AS min_score,
                   ROUND(SUM(CASE WHEN sc.score >= 60 THEN 1 ELSE 0 END) / COUNT(sc.id) * 100, 2) AS pass_rate
            FROM course c
            LEFT JOIN score sc ON c.id = sc.course_id
            GROUP BY c.id, c.course_name
            ORDER BY c.id
            """)
    List<CourseSummary> courseSummary();

    @Select("""
            SELECT s.class_name,
                   COUNT(DISTINCT s.id) AS student_count,
                   ROUND(AVG(sc.score), 2) AS average_score,
                   MAX(sc.score) AS max_score,
                   MIN(sc.score) AS min_score
            FROM student s
            LEFT JOIN score sc ON s.id = sc.student_id
            GROUP BY s.class_name
            ORDER BY s.class_name
            """)
    List<ClassSummary> classSummary();
}
