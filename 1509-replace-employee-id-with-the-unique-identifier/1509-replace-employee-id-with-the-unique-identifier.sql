# Write your MySQL query statement below
select unique_id,name 
from Employees as e
left join
EmployeeUNI as i
on e.id=i.id;