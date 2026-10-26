# Write your MySQL query statement below
with fin as(
select sale_date,
       sold_num-lead(sold_num) OVER(
        partition BY sale_date
        ORDER BY CASE
                WHEN fruit = 'apples' THEN 1
                WHEN fruit = 'oranges' THEN 2
        END

       )
       AS diff
       from Sales
)
select * from fin where diff IS NOT null

  
     