# Write your MySQL query statement below
with cte_a as(
    select b.box_id, b.chest_id, b.apple_count, b.orange_count,
    c.apple_count as capple, c.orange_count as corange
    from Boxes as b
    left join Chests as c
    on b.chest_id=c.chest_id
),
cte_b as(
    select coalesce((coalesce(apple_count,0)+coalesce(capple,0)),0) as apple_count, coalesce((coalesce(orange_count,0)+coalesce(corange,0)),0) as orange_count
    from cte_a
),
cte_c as(
    select sum(apple_count) as apple_count, sum(orange_count) as orange_count
    from cte_b
)
select * from cte_c