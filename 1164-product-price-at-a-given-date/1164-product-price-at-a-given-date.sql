# Write your MySQL query statement below
with cte_a as(
    select *
    from Products where change_date<='2019-08-16'
),
cte_b as(
    select p.product_id, a.new_price, a.change_date
    from Products as p
    left join
    cte_a as a
    on p.product_id=a.product_id
),
cte_c as(
    select *, case when new_price is null then 10
    else new_price
    end as new_price1
    from cte_b
),
cte_d as(
    select product_id, new_price1, dense_rank() over(
        partition by product_id
        order by change_date desc
    ) as rnk
    from cte_c
)
select distinct product_id, new_price1 as price from cte_d
where rnk=1