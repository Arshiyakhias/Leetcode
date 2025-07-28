# Write your MySQL query statement below
#the subquery basically will return null if it fails
select max(salary) as SecondHighestSalary from (
select distinct salary 
from Employee
order by salary desc
limit 1
offset 1
) as second