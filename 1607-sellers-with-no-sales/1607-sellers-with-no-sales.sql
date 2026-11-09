# Write your MySQL query statement below
with cte_a as(
    select s.seller_id,s.seller_name, o.sale_date
    from Orders as o
    left join 
    Seller as s
    on s.seller_id=o.seller_id
    where year(o.sale_date)=2020
    
),
cte_b as(
    select distinct s.seller_name
    from Seller as s
    left join
    cte_a as a
    on s.seller_id=a.seller_id
    where a.seller_id is null
    order by seller_name
)
select * from cte_b