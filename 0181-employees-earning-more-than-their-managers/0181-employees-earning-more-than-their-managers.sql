# Write your MySQL query statement below

select a.name as employee ##you are renaming the column tp employee because thats what is there in the output 
from Employee as a
join
Employee as b
on a.salary>b.salary
and a.managerId=b.id
