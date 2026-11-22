# Write your MySQL query statement below
with cte_a as(
    select * from Subscriptions where year(start_date)>=2021 or year(end_date)>=2021
),
cte_b as(
    select a.account_id, a.start_date, a.end_date,s.stream_date
    from cte_a as a
    left join Streams as s
    on s.account_id=a.account_id
)
select count(*) as accounts_count from cte_b where year(stream_date)!=2021