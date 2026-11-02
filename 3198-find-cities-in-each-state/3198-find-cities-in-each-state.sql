# Write your MySQL query statement below

select state, group_concat(city  ORDER BY city asc SEPARATOR ', ')  as cities
from cities
group by state
