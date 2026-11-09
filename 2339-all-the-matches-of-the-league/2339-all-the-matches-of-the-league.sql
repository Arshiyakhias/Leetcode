# Write your MySQL query statement below

with cte_a as (
    select * from Teams
)
,
cte_b as(
    select * from teams
),
cte_c as(
select a.team_name as home_team, b.team_name as away_team
from cte_a as a
cross join 
cte_b as b
)
select * from cte_c where home_team<>away_team
