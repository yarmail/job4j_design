-- Задание 5 из задания
-- 5. Создать таблицу teens с атрибутами name, gender и заполнить ее.
-- Используя cross join составить все возможные разнополые пары

create table teens (
                     name varchar(255) unique,
                     gender char(1)
);

insert into teens values
('misha', 'm'),
('masha', 'f'),
('kolya', 'm'),
('katya', 'f'),
('roman', 'm'),
('rita', 'f');

select t1.name, concat(t1.gender, t2.gender), t2.name
from teens t1 cross join teens t2
where t1.gender <> t2.gender;

/*
Результат
misha	mf	masha
misha	mf	katya
misha	mf	rita
masha	fm	misha
masha	fm	kolya
masha	fm	roman
kolya	mf	masha
kolya	mf	katya
kolya	mf	rita
katya	fm	misha
katya	fm	kolya
katya	fm	roman
roman	mf	masha
roman	mf	katya
roman	mf	rita
rita	fm	misha
rita	fm	kolya
rita	fm	roman
 */