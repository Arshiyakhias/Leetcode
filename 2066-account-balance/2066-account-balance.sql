# Write your MySQL query statement below
with cte_a as(
    select account_id, day, amount, case when type='Deposit' then amount*1
    else amount*-1
    end as am
    from Transactions
)
select account_id,day, sum(am) over(
    partition by account_id
    order by day
) as balance from cte_a