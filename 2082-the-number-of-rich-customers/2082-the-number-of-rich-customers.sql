# Write your MySQL query statement below
with cte_a as (select count(*)
from Store
where amount>500
group by customer_id
)
select count(*) as rich_count from cte_a