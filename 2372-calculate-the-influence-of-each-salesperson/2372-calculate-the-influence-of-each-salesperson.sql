# Write your MySQL query statement below
with cte_a as(
    select s.salesperson_id,s.name, c.customer_id
    from Salesperson as s
    left join
    Customer as c 
    on s.salesperson_id=c.salesperson_id
),
cte_b as(
    select t.salesperson_id,t.name,t.customer_id, s.sale_id,s.price
    from cte_a as t
    left join Sales as s
    on t.customer_id=s.customer_id
),
 cte_c as (
select salesperson_id,name, coalesce(sum(price) over(
    partition by salesperson_id

),0) as total
from cte_b
)
select * from cte_c
group by salesperson_id

