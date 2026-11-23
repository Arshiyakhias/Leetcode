# Write your MySQL query statement below
with cte_a as(
    select t.team_id, t.name, t.points, p.points_change
    from TeamPoints as t
    left join
    PointsChange as p
    on t.team_id=p.team_id
    
),
cte_b as (
    select *, points+points_change as p
    from cte_a
),
cte_c as(
    select team_id, name, dense_rank() over(
        order by points desc, name asc
    ) as rnk1,dense_rank() over(
        order by p desc, name asc
    ) as rnk2
    from cte_b

)
select team_id, name, CAST(rnk1 AS SIGNED) - CAST(rnk2 AS SIGNED) as rank_diff from cte_c