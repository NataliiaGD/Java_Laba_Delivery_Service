create table companies (
    id serial,
    name varchar(45) not null unique,
    primary key (id)
);

create table couriers (
    id serial,
    first_name varchar(45) not null,
    last_name varchar(45) not null,
    company_id bigint unsigned,
    constraint fk_courier_companies foreign key (company_id) references companies (id) on update no action on delete no action
);

create table vehicles (
    id serial,
    vehicle_type varchar(45) not null,
    company_id bigint unsigned,
    constraint fk_vehicle_companies foreign key (company_id) references companies (id) on update no action on delete no action
);

create table customers (
    id serial,
    first_name varchar(45) not null,
    last_name varchar(45) not null
);

create table delivery_company_services (
    company_id bigint unsigned,
    customer_id bigint unsigned,
    constraint fk_delivery_company_services_companies foreign key (company_id) references companies (id) on update no action on delete no action,
    constraint fk_delivery_company_services_customers foreign key (customer_id) references customers (id) on update no action on delete no action
);

create table delivery_addresses (
    id serial,
    address varchar(45) not null,
    customer_id bigint unsigned,
    constraint fk_delivery_addresses_customers foreign key (customer_id) references customers (id) on update no action on delete no action
);

create table orders (
    id serial,
    order_details varchar(100) not null,
    customer_id bigint unsigned,
    courier_id bigint unsigned,
    payment_id bigint unsigned,
    constraint fk_orders_customers foreign key (customer_id) references customers (id) on update no action on delete no action,
    constraint fk_orders_couriers foreign key (courier_id) references couriers (id) on update no action on delete no action
);

create table order_histories (
    id serial,
    customer_id bigint unsigned,
    order_id bigint unsigned,
    constraint fk_order_histories_customers foreign key (customer_id) references customers (id) on update no action on delete no action,
    constraint fk_order_histories_orders foreign key (order_id) references orders (id) on update no action on delete no action
);

create table feedbacks (
    id serial,
    rating int check (rating between 1 and 5) not null,
    comments varchar(100),
    customer_id bigint unsigned,
    order_id bigint unsigned,
    constraint fk_feedbacks_customers foreign key (customer_id) references customers (id) on update no action on delete no action,
    constraint fk_feedbacks_orders foreign key (order_id) references orders (id) on update no action on delete no action
);

create table discounts (
    id serial,
    discount_amount int check (discount_amount between 0 and 100) not null,
    order_id bigint unsigned,
    constraint fk_discounts_orders foreign key (order_id) references orders (id) on update no action on delete no action
);

create table payments (
    id serial,
    payment_details varchar(45) not null,
    order_id bigint unsigned,
    constraint fk_payments_orders foreign key (order_id) references orders (id) on update no action on delete no action
);

create table delivery_statuses (
    id serial,
    actual_status varchar(20) not null,
    customer_id bigint unsigned,
    courier_id bigint unsigned,
    constraint fk_delivery_statuses_customers foreign key (customer_id) references customers (id) on update no action on delete no action,
    constraint fk_delivery_statuses_couriers foreign key (courier_id) references couriers (id) on update no action on delete no action
);