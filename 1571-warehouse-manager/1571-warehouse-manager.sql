# Write your MySQL query statement below
with cte_a as(
    select product_id, product_name, width*length*height as vol
    from Products
),
cte_b as(
    select w.name, w.product_id, w.units, a.vol
    from Warehouse as w
    left join cte_a as a
    on a.product_id=w.product_id
),
cte_c as(
    select name, units*vol as vols
    from cte_b
),
cte_d as(
    select distinct name as warehouse_name, sum(vols) over(
        partition by name
    ) as volume from cte_c
)
select * from cte_d