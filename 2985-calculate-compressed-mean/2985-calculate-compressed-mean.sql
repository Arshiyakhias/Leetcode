# Write your MySQL query statement below


with calc as (
select order_id, item_count, order_occurrences, (item_count*order_occurrences) as mul
from Orders
)
select ROUND(sum(mul)/sum(order_occurrences),2) as average_items_per_order from calc