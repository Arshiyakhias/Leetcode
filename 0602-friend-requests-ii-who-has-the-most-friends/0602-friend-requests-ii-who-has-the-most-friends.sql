# Write your MySQL query statement below
with cte_a as(
    select requester_id as id,count(*) as cnt1
    from RequestAccepted 
    group by requester_id
),
cte_b as(
    select accepter_id as id,count(*) as cnt2
    from RequestAccepted 
    group by accepter_id

),
cte_c as(
    select id, cnt1 as cnt from cte_a
    union all 
    select id, cnt2 as cnt from cte_b
),
cte_d as (
    select distinct id, sum(cnt) over(
        partition by id
    ) as cntfin
    from cte_c
),
cte_e as(
    select id,cntfin as num, dense_rank() over(
        order by cntfin desc
    ) as rnk
    from cte_d
)
select id, num from cte_e where rnk=1