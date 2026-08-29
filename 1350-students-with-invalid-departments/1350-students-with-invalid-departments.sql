# Write your MySQL query statement below
select id,name
from Students 
where department_id NOT IN(
select s.department_id from
Students as s
inner join
Departments as d
on s.department_id=d.id
)