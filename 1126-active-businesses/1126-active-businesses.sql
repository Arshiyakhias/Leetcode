# Write your MySQL query statement below
with cte_a as(
    select business_id, event_type, occurrences, avg(occurrences) over (partition by event_type) as ag
    from Events
),
cte_b as(
    select business_id, event_type,occurrences, ag, count(business_id) over(partition by business_id) as cnt
    from cte_a  where occurrences>ag 
    
)
select distinct business_id from cte_b where cnt>1