CREATE TABLE if not exists types (
    id serial primary key,
    name varchar(2000)
);

CREATE TABLE if not exists accidents (
    id serial primary key,
    name varchar(2000),
    text varchar(3000),
    address varchar(2000),
    type_id int NOT NULL REFERENCES types(id)
);

CREATE TABLE if not exists rules (
     id serial primary key,
     name varchar(2000)
);

CREATE TABLE if not exists accident_rule (
    type_id int NOT NULL REFERENCES types(id),
    accident_id int NOT NULL REFERENCES accidents(id),
    constraint ar_pkey primary key (type_id, accident_id)
);

insert into types (name) values ('Две машины');
insert into types (name) values ('Машина и человек');
insert into types (name) values ('Машина и велосипед');
insert into rules (name) values ('Статья. 1');
insert into rules (name) values ('Статья. 2');
insert into rules (name) values ('Статья. 3');
insert into accidents (name, text, address, type_id) values ('Accident 1', 'Description Accident 1', 'Moscow', 1);
insert into accidents (name, text, address, type_id) values ('Accident 2', 'Description Accident 2', 'SPB', 2);
insert into accidents (name, text, address, type_id) values ('Accident 3', 'Description Accident 3', 'Tomsk', 3);

insert into accident_rule (type_id, accident_id) values (1, 1);
insert into accident_rule (type_id, accident_id) values (2, 1);
insert into accident_rule (type_id, accident_id) values (3, 2);
insert into accident_rule (type_id, accident_id) values (2, 3);
insert into accident_rule (type_id, accident_id) values (1, 3);

select * from types;
select * from rules;
select * from accidents;
select * from accident_rule;