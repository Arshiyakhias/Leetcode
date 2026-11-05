# Write your MySQL query statement below

with cte_a as (
    select c.*, r.round_id, r.score
    from Candidates as c
    left join Rounds as r
    on c.interview_id=r.interview_id
  
),
cte_b as (
    select *, sum(score) over(
        partition by candidate_id
    ) as s
    from cte_a
  
)

select distinct candidate_id from cte_b
where years_of_exp>=2 and s>15
order by candidate_id