# Write your MySQL query statement below
with cte_a as(
    select order_id,quantity, avg(quantity) over(
        partition by order_id
    ) as ag,
    max(quantity) over(
        partition by order_id
    ) as mx
    from OrdersDetails
)
select distinct order_id from cte_a
where mx>(select max(ag) from cte_a)