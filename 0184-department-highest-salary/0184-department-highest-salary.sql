# Write your MySQL query statement below

with cte_a as(
    select e.id, e.name, e.salary, e.departmentId, d.name as Department
    from Employee as e
    left join Department as d
    on e.departmentId=d.id
),
cte_b as(
    select * ,dense_rank() over(
        partition by Department
        order by salary desc
    ) as rnk
    from cte_a
)
select Department,name as Employee,salary as Salary from cte_b where rnk=1 