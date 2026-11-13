# Write your MySQL query statement below

with cte_a as(
select passenger_id,count(passenger_id) as cnt from Rides
group by passenger_id
),
cte_b as(
select r.driver_id,a.cnt from Rides as r left join cte_a as a
on r.driver_id=a.passenger_id
)

select driver_id, Coalesce(cnt,0) as cnt
from cte_b
group by driver_id