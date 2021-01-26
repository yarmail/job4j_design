/*
Пример 2:
Создадим таблицы должностей и работников.
Вставим данные и извлечем для каждого работника его должность.
 */

create table position(
                       id serial primary key,
                       name varchar(255)
);

create table employees(
                        id serial primary key,
                        name varchar(255),
                        position_id int references position(id)
);

insert into position(name) values ('programmer');
insert into position(name) values ('project manager');
insert into position(name) values ('director');

insert into employees(name, position_id) values('Boris', 1);
insert into employees(name, position_id) values('Ivan', 1);
insert into employees(name, position_id) values('Kiril', 1);
insert into employees(name, position_id) values ('Marina', 2);
insert into employees(name, position_id) values ('Pers', 3);

insert into employees(name) values ('Alexander');

select * from employees join position p
on employees.position_id = p.id;

/*
Результат
id name pos._id id name
1	Boris	1	1	programmer
2	Ivan	1	1	programmer
3	Kiril	1	1	programmer
4	Marina 2 2	project manager
5	Pers	3	3	director
*/

/*
Александра нет в результате, т.к. для него не было выполнено условие.
Будем считать, что он пока не нашел работу.
*/