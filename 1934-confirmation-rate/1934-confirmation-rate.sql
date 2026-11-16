# Write your MySQL query statement below
with cte_a as(
    select s.user_id,c.action, case when c.action= 'confirmed' then 1
    else 0
    end as ca
    from Signups as s
    left join
    Confirmations as c
    on c.user_id=s.user_id
),
cte_b as(
    select distinct user_id, ROUND(sum(ca) over(
        partition by user_id
    )/count(user_id) over(
        partition by user_id
    ),2) as confirmation_rate
    from cte_a
)
select * from cte_b