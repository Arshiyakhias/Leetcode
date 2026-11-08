# Write your MySQL query statement below
with cte_f as(
    select product_id, user_id, sum(quantity) as quantity
    from Sales
    group by 1,2
),
cte_a as(
select  s.product_id,s.user_id, s.quantity, (s.quantity*p.price) as prc
from cte_f as s
left join Product as p
on s.product_id=p.product_id
),
cte_b as(
    select user_id, product_id,prc, dense_rank() over(
        partition by user_id
        order by prc desc

    ) as rnk from cte_a
)
select user_id, product_id from cte_b where rnk=1