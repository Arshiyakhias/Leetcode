# Write your MySQL query statement below
update Salary Set sex=case
when sex='f' then 'm'
else 'f'
end;
