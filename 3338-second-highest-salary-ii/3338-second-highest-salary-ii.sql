# Write your MySQL query statement below

with cte_a as(
    select *, dense_rank() over(
        partition by dept
        order by salary desc
    )as rnk
     from employees 
)
select emp_id,dept from cte_a where rnk=2
order by emp_id ;
