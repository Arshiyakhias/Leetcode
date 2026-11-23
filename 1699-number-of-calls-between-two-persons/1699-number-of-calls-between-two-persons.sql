# Write your MySQL query statement below
with cte_a as(
    select * from Calls where from_id<to_id
),
cte_b as(
    select to_id as from_id, from_id as to_id, duration
    from Calls where from_id>to_id
),
cte_c as(
    select * from cte_a
    union all
    select * from cte_b
),
cte_d as(
    select from_id, to_id, count(duration) over(
        partition by from_id, to_id
    ) as cnt,
    sum(duration) over(
        partition by from_id, to_id
    ) as dr
    from cte_c
)
select distinct from_id as person1, to_id as person2, cnt as call_count, dr as total_duration from cte_d