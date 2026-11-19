# Write your MySQL query statement below
with cte_a as(
    select u.user_id, r.distance, u.name
    from Users as u
    left join 
    Rides as r
    on r.user_id=u.user_id
)
select distinct user_id, name, coalesce(sum(distance) over(partition by user_id),0) as 'traveled distance' from cte_a
order by user_id 