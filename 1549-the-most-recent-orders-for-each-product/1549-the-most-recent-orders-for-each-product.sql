# Write your MySQL query statement below
with cte_a as(
    select o.order_id,o.order_date,o.product_id,p.product_name
    from Orders as o
    left join Products as p
    on o.product_id=p.product_id
    order by o.order_id asc
),
cte_b as(
    select order_id, order_date,product_id, product_name, dense_rank() over(
        partition by product_name
        order by order_date desc
    ) as rnk
    from cte_a
)
select product_name,product_id,order_id,order_date from cte_b where rnk=1
order by product_name