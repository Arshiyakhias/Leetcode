# Write your MySQL query statement below
with cte_a as(
    select first_col,row_number() over(
        order by first_col 
    ) as rn from Data
 
),
cte_b as(
    select second_col, row_number() over(
        order by second_col desc
    ) as rn
     from Data
   
)
select a.first_col, b.second_col
from cte_a as a
left join cte_b as b
on a.rn=b.rn