# Write your MySQL query statement below
with cte_d as(
    select * from likes where page_id not in(select page_id from Likes where user_id=1)

)
,cte_a as(
    select f.user1_id, f.user2_id, l.page_id
    from Friendship as f
    left join 
    cte_d as l
    on f.user2_id=l.user_id
),
cte_b as(
    select f.user1_id, f.user2_id, l.page_id
    from Friendship as f
    left join 
    cte_d as l
    on f.user1_id=l.user_id
),
cte_c as(
    select user1_id, user2_id, page_id from cte_a
    union all
    select user1_id, user2_id, page_id from cte_b

)

select distinct page_id as recommended_page from cte_c where (user1_id=1 or user2_id=1) and page_id is not null
