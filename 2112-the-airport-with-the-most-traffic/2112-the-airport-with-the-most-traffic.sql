# Write your MySQL query statement below
with cte_a as(
    select departure_airport,flights_count from Flights
    union all
    select arrival_airport,flights_count from Flights
    
),
cte_b as(
    select departure_airport, sum(flights_count) over(partition by departure_airport) as cnt
    from cte_a
),
cte_c as(
    select distinct departure_airport, dense_rank() over(order by cnt desc) as rnk
    from cte_b
)
select departure_airport as airport_id from cte_c where rnk=1