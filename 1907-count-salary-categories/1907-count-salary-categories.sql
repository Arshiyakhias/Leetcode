# Write your MySQL query statement below

with cte_a as(
    select account_id, income, case when income<20000 then 'Low Salary'
    when income>=20000 and income<=50000 then 'Average Salary'
    else 'High Salary'
    end as category
    from Accounts
),
cte_b as(
    select sum(case when category='High Salary' then 1 else 0 end) as hs,
    sum(case when category='Average Salary' then 1 else 0 end) as asa,
    sum(case when category='Low Salary' then 1 else 0 end) as ls,
    row_number() over()as rn
    from cte_a

)
select 'High Salary' as category, hs as 'accounts_count' from cte_b
union all
select 'Low Salary' as category, ls as 'accounts_count' from cte_b
union all
select 'Average Salary' as category, asa as 'accounts_count' from cte_b