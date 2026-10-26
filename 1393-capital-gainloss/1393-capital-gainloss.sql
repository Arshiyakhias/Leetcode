# Write your MySQL query statement below

with pri as(
select stock_name, CASE
WHEN operation='Buy' THEN -price
ELSE price 
END AS capital_gain_loss
from Stocks 
)
select stock_name,sum(capital_gain_loss) as capital_gain_loss
from pri
group by stock_name

