# Write your MySQL query statement below
with cte_a as(
select *, dense_rank() over(
    partition by city_id
    order by degree desc
   
) as rnk
from Weather
),
cte_b as(
    select * from cte_a where rnk=1
),
cte_c as(
    select city_id, day, degree, row_number() over(
        partition by city_id
        order by day
    ) as rownum
    from cte_b
)
select city_id, day,degree from cte_c where rownum=1




