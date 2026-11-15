# Write your MySQL query statement below
with cte_a as(
    select delivery_id, customer_id, order_date, customer_pref_delivery_date, 
    case when order_date= customer_pref_delivery_date then 'immediate'
    else 'scheduled'
    end as od
    from Delivery
),
cte_b as(
    select delivery_id, customer_id, order_date, customer_pref_delivery_date, od, case when od='immediate' then 1 
    else 0 
    end as im
    from cte_a
)
select distinct order_date, ROUND((sum(im) over(
    partition by order_date

)/count(order_date) over(
    partition by order_date

))*100,2) as immediate_percentage from cte_b