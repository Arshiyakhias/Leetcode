# Write your MySQL query statement below
with cte_a as(
    select *, dayname(submit_date) as dy
    from Tasks
),
cte_b as(
    select *, case when dy in ('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday') then 1 else 0
    end as working_cnt,
    case when dy in ('Saturday', 'Sunday') then 1 else 0
    end as weekend_cnt
    from cte_a

)
select sum(weekend_cnt) as weekend_cnt, sum(working_cnt) as working_cnt
from cte_b