# Write your MySQL query statement below
with cte_a as(
    select employee_id, name, salary, dense_rank() over(
        order by salary
    ) as rn
    from Employees
    
),
cte_b as(
select *,count(rn) over(
    partition by salary
) as cnt from cte_a
),
cte_c as(select * from cte_b where cnt>=2),
cte_d as(
    select *, dense_rank() over(order by salary) as team_id
    from cte_c
)
select employee_id,name,salary, team_id from cte_d
order by team_id,employee_id