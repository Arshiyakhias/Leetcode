# Write your MySQL query statement below

with cte_a as(
    select o.order_id, o.order_date, o.customer_id, o.product_id
    from Orders as o
    left join
    Customers as c
    on o.customer_id=c.customer_id
),
cte_b as(
    select a.customer_id, a.product_id, p.product_name
    from cte_a as a
    left join Products as p
    on p.product_id=a.product_id
),
cte_c as(
select customer_id, count(product_id) as cnt,product_id, product_name from cte_b
group by customer_id, product_id
),
cte_d as(
    select customer_id,product_id, product_name, dense_rank() over(
        partition by customer_id
        order by cnt desc
    ) as rnk from cte_c
)
select customer_id,product_id, product_name
from cte_d where rnk=1