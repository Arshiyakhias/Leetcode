# Write your MySQL query statement below
with cte_a as(
    select *, sum(score_points) over(
        partition by gender
        order by day
    ) as total
    from Scores
)
select gender,day, total from cte_a