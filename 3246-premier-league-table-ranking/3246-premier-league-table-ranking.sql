# Write your MySQL query statement below

with cte_a as(
    select team_id, team_name, matches_played, (wins*3)+(draws*1) as points
    from TeamStats
    order by team_name asc
),
cte_b as(
    select team_id,team_name,points, rank() over(
        order by points desc
    ) as position
    from cte_a
)
select * from cte_b
order by position asc, team_name asc