# Write your MySQL query statement below
with cte_a as(
    select caller_id, recipient_id, hour(call_time) as hr, city
    from Calls
),
cte_b as(
    select city, hr, count(hr) over(
        partition by city, hr
    ) as cnt
    from cte_a
),
cte_c as(
    select city, hr, dense_rank() over(
        partition by city
        order by cnt desc
    ) as rnk
    from cte_b
  
),
cte_d as(
    select city, hr, count(hr) over(
        partition by city,hr
    ) as cnt
    from cte_c where rnk=1
)
select distinct city, hr as peak_calling_hour,cnt as number_of_calls from cte_d
order by peak_calling_hour desc, city desc