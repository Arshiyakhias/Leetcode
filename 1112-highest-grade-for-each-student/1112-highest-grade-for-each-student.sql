# Write your MySQL query statement below

with cte_a as(
    select *,rank() over(
        partition by student_id
        order by course_id
    )as rnk  from Enrollments 
    

),
cte_b as(
    select *,row_number() over(
        partition by student_id
        order by grade desc
    )as rnk1  from cte_a

)
select student_id,course_id,grade from cte_b where rnk1=1