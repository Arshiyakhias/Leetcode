# Write your MySQL query statement below

with cte_a as(
    select caller_id, duration from Calls
),
cte_b as(
    select callee_id, duration
    from Calls
),
cte_c as(
    select caller_id, duration from cte_a
    union all
    select callee_id, duration from cte_b
),
cte_d as(
    select p.id,c.name
    from Person as p
    left join Country as c
    on substring(p.phone_number,1,3)=c.country_code
),
cte_e as(
    select c.caller_id, c.duration,d.name 
    from cte_c as c
    left join
    cte_d as d
    on c.caller_id=d.id
),
cte_f as(
    select name,duration,avg(duration) over()  as aa, avg(duration) over(partition by name) as ag
    from cte_e

)

select distinct name as country from cte_f where ag>aa