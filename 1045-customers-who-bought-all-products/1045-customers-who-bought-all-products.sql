# Write your MySQL query statement below

with cte_a as(
    select group_concat(product_key order by product_key asc separator ',') as product_grp
    from Product
),
cte_b as(
    select customer_id, group_concat(distinct product_key order by product_key asc separator ',') as product_grp
    from Customer
    group by customer_id
),
cte_c as(
    select b.customer_id, b.product_grp as bp, a.product_grp as ap
    from cte_b as b
    left join
    cte_a as a
    on a.product_grp=b.product_grp
)
select customer_id from cte_c where bp=ap