# Write your MySQL query statement below

select user_id,email
from Users
where email REGEXP '^[a-zA-Z0-9+%]+@[a-zA-Z]+\\.com$'

#use \\ to escape the '.' in the email id