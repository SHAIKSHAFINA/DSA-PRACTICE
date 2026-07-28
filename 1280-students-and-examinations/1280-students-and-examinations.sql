# Write your MySQL query statement below

select s.student_id,s.student_name,su.subject_name, count(e.subject_name) as attended_exams 
from Students as s
CROSS JOIN Subjects as su
LEFT JOIN Examinations as e on s.student_id = e.student_id and e.subject_name=su.subject_name 
group by student_id,subject_name order by student_id,subject_name