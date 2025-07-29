# Write your MySQL query statement below


select user_id,name,mail 
from Users
where REGEXP_LIKE(mail, '^[a-zA-Z][a-zA-Z0-9._-]*@leetcode\\.com$','c') 



# '*' the astrik symbol means 0 or more occurances while '+' means 1 or more occurances
#shouldnt have leetcode+ because it means leetcodeee and so on