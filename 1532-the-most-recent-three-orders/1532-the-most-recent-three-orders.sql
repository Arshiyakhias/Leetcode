# Write your MySQL query statement below

with cte_a as(
    select o.order_id, c.name, o.order_date, o.customer_id, o.cost
    from Orders as o
    left join
    Customers as c
    on c.customer_id=o.customer_id
),
cte_b as(
    select *, dense_rank() over(
        partition by customer_id
        order by order_date desc
    ) as rn
    from cte_a
)
select name as customer_name, customer_id, order_id, order_date from cte_b
where rn=1 or rn=2 or rn=3
order by customer_name, customer_id, order_date desc