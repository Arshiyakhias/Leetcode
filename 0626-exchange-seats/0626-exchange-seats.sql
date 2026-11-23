# Write your MySQL query statement below

with cte_b as(
    select student, case when id%2=0 then id-1
     WHEN id = (SELECT COUNT(*) FROM Seat) THEN id
    else id+1
    end as `id`
    from Seat
)

select id,student from cte_b
order by id 