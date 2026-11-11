# Write your MySQL query statement below
with cte_b as(
    select *, dense_rank() over(
        partition by day
        order by amount desc
    ) as rnk
    from Transactions
)
select transaction_id from cte_b
where rnk=1
order by transaction_id 
