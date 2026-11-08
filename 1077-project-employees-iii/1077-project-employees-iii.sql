# Write your MySQL query statement below
with cte_a as(
    select p.project_id, p.employee_id,e.experience_years
    from Project as p
    left join Employee as e
    on p.employee_id=e.employee_id
),
cte_b as(
select project_id,employee_id,experience_years, max(experience_years) over(
    partition by project_id
) as mx from cte_a
)
select project_id, employee_id from cte_b where mx=experience_years