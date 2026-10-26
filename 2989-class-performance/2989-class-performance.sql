# Write your MySQL query statement below
with sum as(
    select assignment1+assignment2+assignment3 as sums 
    from Scores
)
select max(sums)- min(sums) as difference_in_score from sum