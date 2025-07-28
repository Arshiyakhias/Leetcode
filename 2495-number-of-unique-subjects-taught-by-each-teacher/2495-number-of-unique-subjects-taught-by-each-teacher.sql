# Write your MySQL query statement below
Select teacher_id,count(Distinct subject_id ) AS cnt
from Teacher 
Group by teacher_id;