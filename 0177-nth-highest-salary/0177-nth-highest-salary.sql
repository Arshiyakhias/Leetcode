CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      with cte_a as(
        select *, dense_rank() over(
            order by salary desc

        ) as rnk
        from Employee
      )
      select distinct salary from cte_a where rnk=n

  );
END