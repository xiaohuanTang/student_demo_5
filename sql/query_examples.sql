USE student_score_db;

-- 1. 查询所有学生成绩明细
SELECT s.student_no, s.name AS student_name, s.class_name,
       c.course_name, sc.score, sc.exam_date
FROM score sc
JOIN student s ON sc.student_id = s.id
JOIN course c ON sc.course_id = c.id
ORDER BY s.student_no, c.id;

-- 2. 学生总分、平均分和排名
SELECT student_no, student_name, class_name, course_count,
       ROUND(total_score, 2) AS total_score,
       ROUND(average_score, 2) AS average_score,
       RANK() OVER (ORDER BY average_score DESC) AS rank_no
FROM (
    SELECT s.student_no, s.name AS student_name, s.class_name,
           COUNT(sc.id) AS course_count,
           SUM(sc.score) AS total_score,
           AVG(sc.score) AS average_score
    FROM student s
    LEFT JOIN score sc ON s.id = sc.student_id
    GROUP BY s.id, s.student_no, s.name, s.class_name
) t;

-- 3. 每门课程最高分、最低分、平均分、及格率
SELECT c.course_name,
       COUNT(sc.id) AS student_count,
       ROUND(AVG(sc.score), 2) AS average_score,
       MAX(sc.score) AS max_score,
       MIN(sc.score) AS min_score,
       ROUND(SUM(CASE WHEN sc.score >= 60 THEN 1 ELSE 0 END) / COUNT(sc.id) * 100, 2) AS pass_rate
FROM course c
LEFT JOIN score sc ON c.id = sc.course_id
GROUP BY c.id, c.course_name;

-- 4. 按班级统计平均分
SELECT s.class_name,
       COUNT(DISTINCT s.id) AS student_count,
       ROUND(AVG(sc.score), 2) AS average_score,
       MAX(sc.score) AS max_score,
       MIN(sc.score) AS min_score
FROM student s
LEFT JOIN score sc ON s.id = sc.student_id
GROUP BY s.class_name;
