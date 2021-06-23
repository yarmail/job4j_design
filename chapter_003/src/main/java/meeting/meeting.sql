-- создаем пользователей
create table if not exists users (
id serial primary key,
name varchar(255)
);

insert into users values
(1, 'user1'),
(2, 'user2'),
(3, 'user3');

-----------------------------------------------------
-- создаем мероприятия
create table if not exists meetings (
id serial primary key,
name varchar(255)
);

insert into meetings values
(1, 'meeting1'),
(2, 'meeting2'), -- на это мероприятие никто не пошёл
(3, 'meeting3'); -- мероприятие не будет указано в связывающей таблице

-----------------------------------------------------
-- создаем статусы
create table if not exists statuses (
id serial primary key,
name varchar(255)
);

insert into statuses values
(1, 'pending'), -- приглашение участнику отправлено, ожидает подтверждения
(2, 'accepted'), -- приглашение принято участником, или он сам подал заявку
(3, 'rejected'); -- приглашение отклонено участником

-----------------------------------------------------
-- создаем связывающую таблицу, где отмечаем, кто, на каком мероприятии побывал
create table if not exists events (
id serial primary key,
user_id int references users(id),
meeting_id int references meetings(id),
status_id int references statuses(id)
);

insert into events values
(1,1,1,1), -- user 1 получил приглашение на 1 мероприятие
(2,1,1,2), -- user 1 подтвердил участие на 1 мероприятии
(3,1,2,3), -- user 1 отказался от участия на 2 мероприятии

(4,2,1,1), -- user 2 получил приглашение на 1 мероприятие
(5,2,1,2), -- user 2 подтвердил участие на 1 мероприятии
(6,2,2,3); -- user 2 отказался от участия на 2 мероприятии

----------------------------------------------------
--Запросы
-- Нужно написать запрос, который получит список всех заявок
-- и количество подтвердивших участников.

select meetings.name, count(events.user_id)
from meetings left join events
                        on meetings.id = events.meeting_id and events.status_id = 2
group by meetings.name
order by meetings.name;

/*
Результат
Name      Count
meeting1	2
meeting2	0
meeting3	0
*/

-- Нужно получить все совещания, где не было
-- ни одной заявки на посещения
select meetings.name
from meetings left join events
                        on meetings.id = events.meeting_id
group by meetings.name
having count(events.user_id) = 0
order by meetings.name;
/*
Результат
Name
meeting3
*/