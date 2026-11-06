# Write your MySQL query statement below
with cte_a as(
    select company_id,max(salary) as mx
    from Salaries
    group by company_id
), 
cte_b as(
    select s.*, a.mx
    from Salaries as s
    left join 
    cte_a as a
    on s.company_id=a.company_id
),
cte_c as(
    select company_id, employee_id, employee_name, case when mx<1000 then salary
    when mx>=1000 and mx<=10000 then salary-(0.24*salary)
    else salary-(0.49*salary)
    end as salary
    from cte_b
),
cte_d as(
    select company_id, employee_id, employee_name, round(salary,0) as salary
    from cte_c
)
select * from cte_d