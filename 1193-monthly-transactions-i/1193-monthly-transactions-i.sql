# Write your MySQL query statement below

with cte_a as(
    select substring(trans_date,1,7) as month,country,state,amount 
    from Transactions
),
cte_b as(
    select month, country, case when state='approved' then 1 else 0 end as approved_count,count(*) over( partition by month,country
    ) as cnt,state, amount
    from cte_a
),
cte_c as(
    select month, country, approved_count, cnt, state,amount, case when approved_count=1 then amount else 0 end as amt
    from cte_b
)
select distinct month, country, count(*) over(partition by month, country) as trans_count,sum(approved_count) over(partition by month, country) as approved_count, sum(amount) over(partition by month, country) as trans_total_amount, sum(amt) over(partition by month, country) as approved_total_amount from cte_c
