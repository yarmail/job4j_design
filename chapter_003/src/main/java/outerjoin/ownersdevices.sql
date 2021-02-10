-- outer join

create table owners(
id serial primary key,
name varchar(255)
);

create table devices(
id serial primary key,
name varchar(255),
owner_id int references owners(id)
);

insert into owners(name) values ('Owner 1');
insert into owners(name) values ('Owner 2');
insert into owners(name) values ('Owner 3');

insert into devices(name, owner_id) values ('Device 1', 1);
insert into devices(name, owner_id) values ('Device 2', 2);
insert into devices(name, owner_id) values ('Device 3', 3);
insert into devices(name, owner_id) values ('Device 4', null);
insert into devices(name, owner_id) values ('Device 5', null);
insert into devices(name, owner_id) values ('Device 6', 1);

-- в данном случае внешней будет devices
select *
from devices left outer join owners
on devices.owner_id = owners.id;

/*
Результат
id name owner_1d id name
1	Device 1	1	1	Owner 1
2	Device 2	2	2	Owner 2
3	Device 3	3	3	Owner 3
4	Device 4	null null null
5	Device 5	null null null
6	Device 6	1	1	Owner 1
 */
-- Информативность данного запроса заключается в том,
-- что мы можем получить устройства, у которых нет владельца.

-------

-- Для этого достаточно дополнить запрос фильтром.
select *
from devices left outer join owners
                             on devices.owner_id = owners.id
where owners.id is null;
/*
Результат
id name owner_1d id name
4	Device 4	null null null
5	Device 5	null null null
*/

--------

-- в данном случае внешней будет owners
select *
from owners left outer join devices
                            on devices.owner_id = owners.id;

/*
По идее мы должны были получить 3 записи,
т.к. в таблице owner у нас 3 записи, но т.к.
Для каждой записи табл1 подбираются записи из табл2,
а для владельца с id = 1, подобралось 2 записи из таблицы табл2,
то в результате мы получили на одну запись больше.
 */
/*
Результат
id name id name owner_id
1	Owner 1	1	Device 1	1
2	Owner 2	2	Device 2	2
3	Owner 3	3	Device 3	3
1	Owner 1	6	Device 6	1
 */

--===============================

-- right outer join
-- Синтаксически:
-- select .. from левая <тип> join правая on <условие>


-- Следовательно, следующие пары запросов будут работать одинаково,
-- отличаться будет возможно только порядок столбцов в результирующей выборке.
select *
from devices left outer join owners
                             on devices.owner_id = owners.id;

/*
Результат
id name owner_1d id name
1	Device 1	1	1	Owner 1
2	Device 2	2	2	Owner 2
3	Device 3	3	3	Owner 3
4	Device 4	null null null
5	Device 5	null null null
6	Device 6	1	1	Owner 1
 */

select *
from owners right outer join devices
                             on devices.owner_id = owners.id;

/*
Результат
id name id name owner_id
1	Owner 1	1	Device 1	1
2	Owner 2	2	Device 2	2
3	Owner 3	3	Device 3	3
null null		4	Device 4	null
null null		5	Device 5	null
1	Owner 1	6	Device 6	1
 */

-- (надо уточнить будет ли иметь значение
-- в них в каком порядке находится подстрока - devices.owner_id = owners.id;
-- или наоборот

--================

-- cross join
-- Результатом этого запроса является декартово множество,
-- т.е. все пары элементов

select * from devices cross join owners;

/*
Результат
id name owner_id id name
1	Device 1	1	1	Owner 1
1	Device 1	1	2	Owner 2
1	Device 1	1	3	Owner 3
2	Device 2	2	1	Owner 1
2	Device 2	2	2	Owner 2
2	Device 2	2	3	Owner 3
3	Device 3	3	1	Owner 1
3	Device 3	3	2	Owner 2
3	Device 3	3	3	Owner 3
4	Device 4	null	1	Owner 1
4	Device 4	null	2	Owner 2
4	Device 4	null	3	Owner 3
5	Device 5	null	1	Owner 1
5	Device 5	null	2	Owner 2
5	Device 5	null	3	Owner 3
6	Device 6	1	1	Owner 1
6	Device 6	1	2	Owner 2
6	Device 6	1	3	Owner 3

похоже на ненормализованную таблицу
 */