-- хранилище машин

create table body (
  id serial primary key,
  name varchar(255)
);

create table engine (
  id serial primary key,
  name varchar(255)
);

create table transmission (
  id serial primary key,
  name varchar(255)
);

create table car (
  id serial primary key,
  name varchar(255),
  body_id int references body(id),
  engine_id int references engine(id),
  transmission int references transmission(id)
);

insert into body values
(1, 'седан'),
(2, 'купе'),
(3, 'хечбек'),
(4, 'универсал');

insert into engine values
(1, 'электрический'),
(2, 'дизельный'),
(3, 'бензиновый'),
(4, 'гибридный');

insert into transmission values
(1, 'ручная'),
(2, 'автоматическая'),
(3, 'вариатор'),
(4, 'роботизированная');

-- Добавляем полные машины
insert into car values
(1, 'car1', 1, 1, 1),
(2, 'car2', 2, 2, 2),
(3, 'car3', 3, 3, 3),
-- Добавляем неполные машины
(4, 'car4', 1, 1, null),
(5, 'car5', 1, null, 1),
(6, 'car6', null, 1, 1);

-- 1. Вывести список всех машин и все привязанные к ним детали.
select car.name as car, body.name as body,
       engine.name as engine, transmission.name as transmission
from car
       left join body on car.body_id = body.id
       left join engine on car.engine_id = engine.id
       left join transmission on car.transmission = transmission.id;

/*
Результат:
car   body    engine        transmission
car1	седан	  электрический	ручная
car2	купе	  дизельный	    автоматическая
car3	хечбек	бензиновый	  вариатор
car4	седан	  электрический null
car5	седан	  null          ручная
car6	null    электрический	ручная
*/

--=======================================

/*
2. Вывести отдельно детали, которые не используются
в машине, кузова, двигатели, коробки передач.
(Правильный ответ - не используются  четвертые номера:
универсал, гибридный, роботизированная)
*/
select body.name as body
from car right join body on car.body_id = body.id
where car.name is null;

select engine.name as engine
from car right join engine on car.body_id = engine.id
where car.name is null;

select transmission.name as transmission
from car right join transmission on car.body_id = transmission.id
where car.name is null;

-- Примечание:  пока не очень понимаю, можно ли эти три запроса сделать одним запросом