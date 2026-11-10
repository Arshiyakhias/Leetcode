# Write your MySQL query statement below
with cte_a as(
    select purchase_date,dayname(purchase_date) as day_name,week(purchase_date)-43 as week_of_month,month(purchase_date), amount_spend
    from Purchases
)
select distinct week_of_month, purchase_date, sum(amount_spend) over(
    partition by purchase_date
)  as total_amount from cte_a
where day_name='Friday'
