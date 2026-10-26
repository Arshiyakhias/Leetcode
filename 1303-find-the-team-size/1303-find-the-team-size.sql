# Write your MySQL query statement below


with sz as (
select team_id, count(employee_id) as team_size
from Employee
group by team_id
)
select Employee.employee_id, sz.team_size from 
Employee 
left join 
sz
on Employee.team_id=sz.team_id 