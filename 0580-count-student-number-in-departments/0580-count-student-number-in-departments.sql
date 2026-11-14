# Write your MySQL query statement below
with cte_a as(
select d.dept_name, s.student_name, s.dept_id
from Department as d
left join student as s
on s.dept_id=d.dept_id
)
select dept_name, coalesce(count(dept_id),0) as student_number
from
cte_a
group by dept_name
order by student_number desc, dept_name
