# Write your MySQL query statement below
with cte_a as(
    select v.candidateId,c.name, count(v.candidateId) as cnt
    from Vote as v
    left join Candidate as c
    on v.candidateId=c.id
    group by c.name
    order by cnt desc
    limit 1
)

select name from cte_a