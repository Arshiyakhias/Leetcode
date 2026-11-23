# Write your MySQL query statement below

with cte_a as(
    select id, student, row_number() over(

    ) as rn
    from Seat
),
cte_b as(
    select student, case when rn%2=0 then id-1
     WHEN rn = (SELECT COUNT(*) FROM Seat) THEN id
    else id+1
    end as `id`
    from cte_a
)

select id,student from cte_b
order by id 