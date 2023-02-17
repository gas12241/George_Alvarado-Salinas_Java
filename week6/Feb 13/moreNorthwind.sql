use northwind;
SELECT *
FROM customers 
WHERE city 
LIKE 'O%';

use northwind;
SELECT *
FROM employees
where first_name 
LIKE 'J%'
and last_name 
LIKE 'B%';

use northwind;
SELECT *
FROM orders
WHERE ship_city
LIKE '%S_n';

use northwind;
SELECT *
FROM orders
WHERE ship_postal_code is null;

-- list all customers with last names that start with 'Si'
use northwind;
SELECT *
FROM customers
WHERE last_name
LIKE 'Si%';


SELECT *
from employees
WHERE email 
LIKE '%.edu';


SELECT *
from products p
WHERE discontinued = 1
order by list_price;

SELECT department, job_title, last_name, first_name
from employees e 
order by department, job_title, last_name, first_name;

-- let's get the names of the people that all the completed orders
-- for keith
SELECT o.ship_name 
from orders AS o 
inner join employees e 
ON o.employee_id = e.id 
where e.first_name = 'Keith'
AND e.last_name = 'Lawrence'
AND o.order_status = 'Complete';

-- lets get the customer names and the names of the people that all the
SELECT orders.ship_name, customers.first_name, customers.last_name
from orders
Inner join employees ON orders.employee_id = employees.id
Inner join customers ON orders.customer_id = customers.id 
where employees.first_name = 'Keith'
AND employees.last_name = 'Lawrence'
And order_status = 'Complete';

-- Let's get the order number of all the orders for all the employees
SELECT employees.first_name, employees.last_name, orders.id
from employees
left outer join orders on orders.employee_id = employees.id;

INSERT into employees (id, first_name, last_name, email)
VALUES (999, 'New', 'Person', '')