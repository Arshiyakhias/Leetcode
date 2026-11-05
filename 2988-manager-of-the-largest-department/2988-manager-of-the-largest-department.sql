# Write your MySQL query statement below
with cte_a as(
    select dep_id, count(dep_id) as cnt
    from Employees group by dep_id
    
), 
cte_b as(
    select e.emp_name as manager_name,a.dep_id, a.cnt 
    from cte_a as a
    left join
    Employees as e
    on a.dep_id=e.dep_id
    where e.position='Manager'
),
cte_c as(select *, dense_rank() over(

    order by cnt desc
 
) as rnk from cte_b
)
select manager_name,dep_id from cte_c
where rnk=1
order by dep_id