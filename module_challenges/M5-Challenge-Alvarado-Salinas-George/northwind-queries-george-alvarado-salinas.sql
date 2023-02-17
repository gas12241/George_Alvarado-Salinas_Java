use northwind;

-- What are the categories of products in the database?
use northwind;
SELECT DISTINCT p.category 
from products p
Order By p.category;

-- What products are made by Dell?
use northwind;
SELECT *
FROM products p
WHERE p.product_name 
LIKE '%Dell%';

-- List all the orders shipped to Pennsylvania.
use northwind;
SELECT *
FROM orders o
WHERE o.ship_state = 'Pennsylvania';

-- List the first name and last name of all employees with last names that start with the letter W
use northwind;
SELECT first_name, last_name 
from employees e
WHERE e.last_name
LIKE 'W%';

-- List all customers from zip codes that start with 55
use northwind;
SELECT *
FROM customers
WHERE postal_code
LIKE '55%';

-- List all customers from zip codes that end with 0.
use northwind;
SELECT *
FROM customers
WHERE postal_code
LIKE '%0';


-- List the first name, last name, and email for all customers with a ".org" email address.
use northwind;
SELECT first_name, last_name, email
from customers
WHERE email
LIKE '%.org';

-- List the first name, last name, and phone number for all customers from the 202 area code.
use northwind;
SELECT first_name, last_name, phone
from customers
WHERE phone
LIKE '%(202)%';

-- List the first name, last name, and phone number for all customers from the 202 area code, ordered by last name, first name.
use northwind;
SELECT last_name, first_name, phone
from customers
WHERE phone
LIKE '%(202)%'
ORDER BY last_name, first_name;