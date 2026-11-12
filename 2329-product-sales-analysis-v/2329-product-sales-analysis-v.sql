# Write your MySQL query statement below
with cte_a as(
select s.sale_id, s.product_id, s.user_id, s.quantity, p.price
from Sales as s
left join Product as p
on s.product_id=p.product_id
),
cte_b as(
select *, quantity*price as spent from cte_a
)
select distinct user_id,sum(spent) over(
    partition by user_id
) as spending
from cte_b
order by spending desc