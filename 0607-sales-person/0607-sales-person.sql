# Write your MySQL query statement below

select s.name from SalesPerson as s   where s.sales_id not in(
    Select s.sales_id 
from SalesPerson as s

left  join Orders as o
on s.sales_id=o.sales_id
left join Company as c
on o.com_id=c.com_id
WHERE c.name='RED'
)