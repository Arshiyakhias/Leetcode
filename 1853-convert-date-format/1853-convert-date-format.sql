# Write your MySQL query statement below
with cte_a as(
    select dayname(day) as a, monthname(day) as b, day(day) as c, year(day) as d
    from Days
)
select concat(a,', ',b,' ',c,', ',d) as day from cte_a