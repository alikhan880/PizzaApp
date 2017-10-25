drop table if exists person;
create table person  (
name VARCHAR(40),
age int,
gender VARCHAR(6));

drop table if exists frequents;
create table frequents (
name VARCHAR(40),
pizzeria VARCHAR(40));

drop table if exists eats;
create table eats (
name VARCHAR(40),
pizza VARCHAR(40));

drop table if exists serves;
create table serves(
pizzeria VARCHAR(40),
pizza VARCHAR(40),
price DEC(6,2) );

insert into person values ('Amy', 16, 'female');
insert into person values ('Ben', 21, 'male');
insert into person values ('Cal', 33, 'male');
insert into person values ('Dan', 13, 'male');
insert into person values ('Eli', 45, 'male');
insert into person values ('Fay', 21, 'female');
insert into person values ('Gus', 24, 'male');
insert into person values ('Hil', 30, 'female');
insert into person values ('Ian', 18, 'male');

insert into frequents values ('Amy',	'Pizza Hut');
insert into frequents values ('Ben',	'Chicago Pizza');
insert into frequents values ('Ben',	'Pizza Hut');
insert into frequents values ('Cal',	'New York Pizza');
insert into frequents values ('Cal',	'Straw Hat');
insert into frequents values ('Dan',	'New York Pizza');
insert into frequents values ('Dan',	'Straw Hat');
insert into frequents values ('Eli',	'Chicago Pizza');
insert into frequents values ('Eli',	'Straw Hat');
insert into frequents values ('Fay',	'Dominos');
insert into frequents values ('Fay',	'Little Caesars');
insert into frequents values ('Gus',	'Chicago Pizza');
insert into frequents values ('Gus',	'Pizza Hut');
insert into frequents values ('Hil',	'Dominos');
insert into frequents values ('Hil',	'Pizza Hut');
insert into frequents values ('Hil',	'Straw Hat');
insert into frequents values ('Ian',    'Dominos');
insert into frequents values ('Ian',	'New York Pizza');
insert into frequents values ('Ian',	'Straw Hat');


insert into eats values ('Amy',	'mushroom');
insert into eats values ('Amy',	'pepperoni');
insert into eats values ('Ben',	'cheese');
insert into eats values ('Ben',	'pepperoni');
insert into eats values ('Cal',	'supreme');
insert into eats values ('Dan',	'cheese');
insert into eats values ('Dan',	'mushroom');
insert into eats values ('Dan',	'pepperoni');
insert into eats values ('Dan',	'sausage');
insert into eats values ('Dan',	'supreme');
insert into eats values ('Eli',	'cheese');
insert into eats values ('Eli',	'supreme');
insert into eats values ('Fay',	'mushroom');
insert into eats values ('Gus',	'cheese');
insert into eats values ('Gus',	'mushroom');
insert into eats values ('Gus',	'supreme');
insert into eats values ('Hil',	'cheese');
insert into eats values ('Hil',	'supreme');
insert into eats values ('Ian',	'pepperoni');
insert into eats values ('Ian',	'supreme');


insert into serves values ('Chicago Pizza',	'Cheese',	7.75);
insert into serves values ('Chicago Pizza',	'supreme',	8.5);
insert into serves values ('Dominos',	'Cheese',	9.75);
insert into serves values ('Dominos',	'mushroom',	11);
insert into serves values ('Little Caesars',	'Cheese',	7);
insert into serves values ('Little Caesars',	'mushroom',	9.25);
insert into serves values ('Little Caesars',	'pepperoni',	9.75);
insert into serves values ('Little Caesars',	'sausage',	9.5);
insert into serves values ('New York Pizza',	'Cheese',	7);
insert into serves values ('New York Pizza',	'pepperoni',	8.5);
insert into serves values ('New York Pizza',	'supreme',	9);
insert into serves values ('Pizza Hut',	'Cheese',	9);
insert into serves values ('Pizza Hut',	'pepperoni',	12);
insert into serves values ('Pizza Hut',	'sausage',	12);
insert into serves values ('Pizza Hut',	'supreme',	12);
insert into serves values ('Straw Hat',	'Cheese',	9.25);
insert into serves values ('Straw Hat',	'pepperoni',	8);
insert into serves values ('Straw Hat',	'sausage',	9.75);

