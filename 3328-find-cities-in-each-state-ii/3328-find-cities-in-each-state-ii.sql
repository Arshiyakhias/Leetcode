with cte_a as(
select state,city, case when substring(state,1,1)=substring(city,1,1) then 1 else 0 end as comp,
count(state) over(
    partition by state
) as cnt
from cities 
),
cte_b as(
    select state, city, sum(comp) over(
        partition by state
    ) as sm, cnt
    from cte_a
),
cte_c as(
select state, city, sm from cte_b
where sm>=1 and cnt>=3
)
select state, group_concat( city order by city asc separator ', ') as cities, sm as matching_letter_count
from cte_c
group by state
order by matching_letter_count desc, state asc




