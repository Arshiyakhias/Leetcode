# Write your MySQL query statement below
with cte_a as(
    select order_id,order_date, item_id, buyer_id
    from Orders where year(order_date)=2019
),
cte_b as (
    select u.user_id, u.join_date, a.item_id
    from Users as u
    left join cte_a as a
    on u.user_id=a.buyer_id
)
select distinct user_id as  buyer_id, join_date, count(item_id) over(
partition by user_id) as orders_in_2019 from cte_b