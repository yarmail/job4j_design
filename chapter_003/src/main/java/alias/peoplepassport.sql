-- Inner join
-- Создадим таблицы паспортов и людей.
-- Вставим данные и напишем запрос с inner join

create table passport(
                       id serial primary key,
                       seria int,
                       number int
);

create table people(
                     id serial primary key,
                     name varchar(255),
                     passport_id int references passport(id) unique
);

insert into passport(seria, number) values (1111, 123456);
insert into passport(seria, number) values (1112, 123457);
insert into passport(seria, number) values (1113, 123458);

insert into people(name, passport_id) values ('Ivan', 1);
insert into people(name, passport_id) values ('Boris', 2);
insert into people(name, passport_id) values ('Petr', 3);
insert into people(name) values ('Vasya');
insert into people(name) values ('Anya');


select * from people inner join passport p on people.passport_id = p.id;

/*
Результат
id name p.id id seria number
1	Ivan	1	1	1111	123456
2	Boris	2	2	1112	123457
3	Petr	3	3	1113	123458
*/

/*
Примечание
Запись passport p вероятно означает, что вместо
passport мы можем использовать p (типа алиас)
*/

/*
Заметьте, что Аня и Вася не попали в результирующую выборку,
т.к. для них не выполнилось условие в on.
Будем считать, что это дети до 14 лет.
*/

-- Стоит отметить, что в PostgreSQL необязательно писать inner.
-- Можно просто join. Следующий запрос вернет тот же результат:

select * from people join passport p on people.passport_id = p.id