create table gender (
    id serial primary key,
    sex text
);

create table person (
    id serial primary key,
    name varchar(50),
    adress text,
    gender_id int references gender(id)
);

create table movies(
    id serial primary key,
    name text
);

create table orders(
    id serial primary key,
    person_id int references person(id),
    movies_id int references movies(id)
);

insert into gender(sex) values ('male'), ('female');
insert into person(name, adress, gender_id)
values ('Olga Egorova', 'First Kazan per. D-14', 2),
('Sergey Ivanov', 'Central street, D-40, Kv-58', 1),
('Sergey Ivanjv', 'Lenins street, D-7, Kv-130', 1);

insert into movies(name) values ('Pirates of Caribian sea'), ('Man who change all'), ('Matrix:Revolution'), ('Interstellar');
insert into orders(person_id, movies_id) values (1,1),(1, 3), (2, 4), (2, 2), (3,3);
select * from orders;