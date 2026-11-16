# Write your MySQL query statement below
with cte_a as(
    select country_id, weather_state, monthname(day) as mn
    from Weather
),
cte_b as(
    select country_id, avg(weather_state) over(
        partition by country_id
    ) as ag
    from cte_a where mn='November'
),
cte_c as(
    select c.country_name,b.country_id, b.ag
    from cte_b as b
    left join
    Countries as c
    on c.country_id=b.country_id
),
cte_d as(
    select distinct country_name, case when ag<=15 then 'Cold'
    when ag>=25 then 'Hot'
    else 'Warm'
    end as weather_type
    from cte_c
)
select * from cte_d