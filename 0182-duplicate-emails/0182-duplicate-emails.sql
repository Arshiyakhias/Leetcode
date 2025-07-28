# Write your MySQL query statement below

#distinct in teh sense teh output will occur once only no dupicate in that
select distinct a.email as Email
from
Person as a
join
Person as b
on
a.id != b.id
WHERE a.email=b.email