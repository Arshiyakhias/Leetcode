# Write your MySQL query statement below
with cte_a as(
    select * from Queue
    order by turn
), 
cte_b as (
    select *, sum(weight) over(
        order by turn
    ) as tot
    from cte_a
), 
cte_c as (
    select *, row_number() over(
        order by tot desc 

    )as tot1 from cte_b where tot<=1000
)
select person_name from cte_c where tot1=1