# Write your MySQL query statement below
with cte_a as(
    select voter, candidate, coalesce(1/count(candidate) over(
        partition by voter
    ) , 0)as cnt
    from Votes
),
cte_b as(
    select candidate, sum(cnt) as cnt1
    from cte_a
    group by candidate
    order by candidate
),
cte_c as(
    select candidate, dense_rank() over(
        order by cnt1 desc
    ) as rnk
    from cte_b
)
select candidate from cte_c where rnk=1