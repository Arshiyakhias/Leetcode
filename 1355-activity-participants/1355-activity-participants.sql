# Write your MySQL query statement below
with cte_a as(
select activity, count(activity) as cnt
from Friends
group by activity
),
cte_b as(
    select *, dense_rank() over(
        order by cnt desc
    ) as rnk 
    from cte_a
),
cte_c as(
    select * , min(rnk) over(
 
    ) as min_rnk,
    max(rnk) over(


    ) as max_rnk

    from cte_b
)
select activity from cte_c where rnk<>min_rnk and rnk<>max_rnk