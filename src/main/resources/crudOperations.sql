insert into companies(name) values ('Company1'), ('Company2'), ('Company3');
insert into couriers(first_name,last_name,company_id) values ('Bob','Davis',1),('Tom','Smith',1),('John','Derec',2);
insert into vehicles(vehicle_type,company_id) values ('Car',1), ('Bike',2), ('Motocycle',3);
insert into customers(first_name,last_name) values ('Kris','Doe'), ('James','Dou'), ('Rob', 'Williams');
insert into delivery_addresses(address,customer_id) values ('Leeton Ridge Street',1), ('Wellington Ave.',2), ('Parker St.',3);
insert into delivery_company_services(company_id,customer_id) values (1,2);
insert into orders(order_details,customer_id,courier_id) values ('one burger and one cola',1,1), ('pizza',2,2), ('sushi',3,3);
insert into order_histories(customer_id,order_id) values (1,7);
insert into feedbacks(rating,comments,customer_id,order_id) values (4, 'delay',1,7), (5, 'fast devilery',2,8), (5,'fresh food',3,9);
insert into discounts(discount_amount,order_id) values (20,9), (10,8), (10,7);
insert into payments(payment_details,order_id) values ('Card',7), ('Cash',8), ('Card',9);
insert into delivery_statuses(actual_status,customer_id,courier_id) values ('Completed',1,4), ('Completed',2,5), ('Completed',3,6);

update companies set name = 'Delivery_Company1' where id = 1;
update companies set name = 'Delivery_Company2' where id = 2;
update companies set name = 'Delivery_Company3' where id = 3;
update couriers set first_name = 'David' where id = 4;
update couriers set first_name = 'Jack' where id = 5;
update couriers set last_name = 'Peterson' where id = 6;
update orders set order_details = 'pasta' where id = 8;
update delivery_addresses set address = 'Bradford Avenue' where id = 9;
update delivery_addresses set address = 'Wellington Avenue' where id = 8;
update discounts set discount_amount = 20 where id = 2;

delete from companies where id = 1;
delete from vehicles where id = 2;
delete from customers where id = 1;
delete from delivery_addresses where id = 7;
delete from orders where id = 7;
delete from feedback where id = 1;
delete from discount where id = 3;
delete from delivery_statuses where id = 4;
delete from delivery_statuses where id = 5;
delete from delivery_statuses where id = 6;

alter table customers add age int;
alter table customers drop column age;
alter table payments rename column payment_details to payment_type;
alter table payments rename column payment_type to payment_details;
alter table discounts modify column discount_amount bigint;
alter table discounts modify column discount_amount int;

select first_name, last_name, address, order_details, rating, comments, actual_status from customers
INNER JOIN delivery_addresses ON customers.id = delivery_addresses.customer_id
INNER JOIN orders ON customers.id = orders.customer_id
INNER JOIN feedbacks ON customers.id = feedbacks.customer_id
INNER JOIN delivery_statuses ON customers.id = delivery_statuses.customer_id;

select name, first_name, last_name from couriers INNER JOIN companies ON couriers.company_id = companies.id;
select name, vehicle_type from vehicles LEFT JOIN companies ON vehicles.company_id = companies.id;
select order_details, rating, comments from feedbacks  RIGHT JOIN orders ON feedbacks.order_id = orders.id;
select discount_amount, order_details from discounts INNER JOIN orders ON discounts.order_id = orders.id;
select first_name, last_name, address from delivery_addresses INNER JOIN customers ON delivery_addresses.customer_id = customers.id;

select COUNT(id), rating from feedbacks GROUP BY rating;
select COUNT(id), discount_amount from discounts GROUP BY discount_amount;
select SUM(discount_amount) from discounts GROUP BY discount_amount;
select customer_id, COUNT(*) from orders GROUP BY customer_id;
select customer_id, AVG(rating) from feedbacks GROUP BY customer_id;
select company_id, COUNT(*) from vehicles GROUP BY company_id;
select courier_id, COUNT(*) from orders GROUP BY courier_id;

select customer_id, COUNT(*) from orders GROUP BY customer_id HAVING COUNT(*) > 0;
select courier_id, COUNT(*) from orders GROUP BY courier_id HAVING COUNT(*) > 0;
select company_id, COUNT(*) from vehicles GROUP BY company_id HAVING COUNT (*) > 0;
select customer_id, MIN(rating) from feedbacks GROUP BY customer_id HAVING MIN(rating) < 5;
select customer_id, SUM(rating) from feedbacks GROUP BY customer_id HAVING SUM(rating) > 4;
select customer_id, COUNT(*) from orders GROUP BY customer_id HAVING COUNT(*) > 0;
select company_id, COUNT(*) from vehicles GROUP BY company_id HAVING COUNT (*) > 5;