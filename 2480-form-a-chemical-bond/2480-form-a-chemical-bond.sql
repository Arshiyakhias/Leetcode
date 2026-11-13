# Write your MySQL query statement below
with cte_a as(
    select * from Elements
), 
cte_b as(
    select * from Elements
),
cte_c as(
    select a.symbol as metal, a.type as type1, b.symbol as nonmetal, b.type as type2
    from cte_a as a
    cross join
    cte_b as b
)
select metal,nonmetal from cte_c
where type1='Metal' and type2='Nonmetal'