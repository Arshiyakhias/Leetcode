# Write your MySQL query statement below
with cte_a as(
    select case when order_date=customer_pref_delivery_date then 1 else 0
    end as per
    from Delivery
)
select distinct Round((avg(per)over ())*100,2) as immediate_percentage from cte_a