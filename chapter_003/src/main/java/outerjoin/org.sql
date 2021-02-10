-- Задание 1 по задаче  0. Видео [#6862] [#293750]
/*
Даны две сущности, представленные в таблицах departments и employees.
Отношение one-to-many. В таблицах только поле name.
1. Создать таблицы и заполнить их начальными данными
2. Выполнить запросы с left, right, full, cross соединениями
3. Используя left join найти департаменты, у которых нет работников
4. Используя left и right join написать запросы,
которые давали бы одинаковый результат.
 */

create table departments (
id serial primary key,
name varchar(255)
);

create table employees (
id serial primary key,
name varchar(255),
dep_id int references departments(id)
);

insert into departments values (1, 'dep1');
insert into departments values (2, 'dep2');
insert into departments values (3, 'dep3');

insert into employees values (1, 'vasya', 1);
insert into employees values (2, 'petya', 2);
insert into employees values (3, 'kolya', 3);
insert into employees values (4, 'misha', null);
insert into employees values (5, 'sasha', null);

-- 2. Выполнить запросы с left, right, full, cross соединениями
select *
from departments left outer join employees
on employees.dep_id = departments.id;

select *
from departments right outer join employees
on employees.dep_id = departments.id;

select *
from departments full join employees
on employees.dep_id = departments.id;

select *
from departments cross join employees;

-- 3. Используя left join найти департаменты, у которых нет работников
/*
Примечание
(как я понимаю нужно за левую внешнюю основную таблицу нужно брать
employees т.к она 1) many-to-one 2) содержит null
 */
-- 3.1 первый способ
select *
from employees left outer join departments
on employees.dep_id = departments.id;

/*
Результат
id name dep_id id name
1	vasya	1	1	dep1
2	petya	2	2	dep2
3	kolya	3	3	dep3
4	misha null null null
5	sasha null null null
*/

-- 3.2 второй способ, тоже самое только с фильтром
select *
from employees left outer join departments
on employees.dep_id = departments.id
where dep_id is null;

/*
Результат
4	misha null null null
5	sasha null null null
 */

-- 4. Используя left и right join написать запросы,
-- которые давали бы одинаковый результат.
select *
from employees left outer join departments
on employees.dep_id = departments.id
where dep_id is null;

select *
from departments right outer join employees
on departments.id = employees.dep_id
where dep_id is null;

-- Примечание: результаты по количеству строк одинаковые,
-- по порядку столбцов отличаются