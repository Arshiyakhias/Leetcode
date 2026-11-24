# Write your MySQL query statement below
with cte_a as(
    select sale_id, product_id, month(sale_date) as m, quantity, price 
    from sales
),
cte_b as(
    select sale_id, product_id, case when m=12 or m=1 or m=2 then 'Winter'
    when m=3 or m=4 or m=5 then 'Spring'
    when m=6  or m=7 or m=8 then 'Summer'
    else 'Fall'
    end as season,quantity,price
    from cte_a
),
cte_c as(
    select b.sale_id, b.product_id, b.season, b.quantity, b.price, p.product_name, p.category
    from cte_b as b 
    left join
    products as p
    on b.product_id=p.product_id
),
cte_d as(
    select *, quantity*price as rev from cte_c
),
cte_e as(
    select season, category, sum(quantity) over(partition by season, category) as s, sum(rev) over(partition by season,category) as sm
    from cte_d
),
cte_f as(
    select season, category, s as total_quantity, sm as total_revenue, dense_rank() over(
        partition by season
        order by s desc, sm desc, category asc
    ) as rnk
    from cte_e
)
select distinct season, category, total_quantity, total_revenue from cte_f
where rnk=1