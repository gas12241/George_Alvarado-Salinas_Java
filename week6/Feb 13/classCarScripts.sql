create schema if not exists car_lot;
use car_lot;

create table car (
	id		INT NOT NULL,
    make	VARCHAR(50),
    model	VARCHAR(50),
    model_year	VARCHAR(4),
    color	VARCHAR(50),
	PRIMARY KEY (id)
);

use car_lot;
select * from car;

INSERT into car (id, make, model, model_year, color)
values (22, 'Honda', 'Civic', '2020', 'Blue');

INSERT into car (id, make, model, color)
values (25, 'BMW', 'Z3', 'Black');

INSERT into car (make, model, color)
values ('Chevy', 'Spark', 'Blue');

SELECT *
from car;

SELECT *
FROM car
WHERE id = 22;

UPDATE car
set color = 'Yellow'
where id = 22;

-- update the model_year to 2020 on teh car that's missing a model YEAR
UPDATE car
set model_year = '2020'
where model_year is Null;

UPDATE car
set model_year = '2023'
where model_year = '2020';

use car_lot;
SELECT * from car;

-- insert values for all columns
insert into car (id, make, model, model_year, color)
values (22, 'Honda','Civic','2020','Blue');

-- insert values for all columns except model year
insert into car (id, make, model, color)
values (25,'BMW','Z3','Black')

-- this won't work because we're missing a required field
insert into car ( make, model, color)
values ('Chevy', 'Spark', 'Blue')




select * 
from car
where id = 22;

-- update the color to yellow on the car with an id of 22
UPDATE car
set color = 'Yellow'
where id = 22;


-- update the model_year to 2020 on the car that's missing a model YEAR 
update car
set model_year = '2020'
where model_year is Null;


-- update the model_year to 2020 to 2023
update car
set model_year = '2023'
where model_year = '2020';


-- delete the car with an id of 25
delete 
from car
where id = 25;

