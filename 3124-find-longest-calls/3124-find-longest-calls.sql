# Write your MySQL query statement below

with cte_a as(
    select c.contact_id, c.type, c.duration,
    co.first_name
    from Calls as c
    left join 
    Contacts as co
    on c.contact_id=co.id
),
cte_b as(
select contact_id, type, first_name, duration, dense_rank() over(
    partition by type
    order by duration desc
) as rnk
from cte_a
)

select first_name, type, TIME_FORMAT(SEC_TO_TIME(duration), '%H:%i:%s') AS duration_formatted from cte_b 
where rnk=1 or rnk=2 or rnk=3
order by type desc, duration desc, first_name desc
