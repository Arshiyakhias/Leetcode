# Write your MySQL query statement below

with cte_a as(
    select emp_id, firstname,lastname,department_id,salary, dense_rank() over(
    partition by emp_id
    order by salary desc
    
) as rnk
from Salary
)
select emp_id, firstname,lastname,salary,department_id from cte_a where rnk=1 
order by emp_id asc