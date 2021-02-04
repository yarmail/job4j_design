-- Фильтры [#293746]

create table type (
id serial primary key,
name varchar(255)
);

create table product (
id serial primary key,
name varchar(255),
expired_date timestamp,
price money,
amount int, -- количество продукта
type_id int references type(id)
);

insert into type values (1, 'Сыр');
insert into type values (2, 'Молоко');
insert into type values (3, 'Мясо');
insert into type values (4, 'Хлеб');

insert into product values (1, 'сыр костромской', date '2021-01-01', 100.00, 99, 1);
insert into product values (2, 'сыр рязанский', date '2021-02-01', 200.00, 98, 1);
insert into product values (3, 'мороженое ялта', date '2021-03-01', 300.00, 97, 2);
insert into product values (4, 'восторг мороженое', date '2021-03-01', 400.00, 9, 2);
insert into product values (5, 'мясо свиное', date '2021-04-01', 500.00, 8, 3);
insert into product values (6, 'хлеб дарницкий', date '2021-05-01', 600.00, 7, 4);

-- Задание.

-- 1. Написать запрос получение всех продуктов с типом "СЫР"
select product.name
from product inner join type
on product.type_id = type.id
where type.name = 'Сыр';

-- 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое"
select product.name from product
where name LIKE '%мороженое%';

-- 3. Написать запрос, который выводит все продукты,
-- срок годности которых заканчивается в следующем месяце.
select product.name from product
where expired_date > current_date
and   expired_date < current_date + interval '1 month';

-- 4. Написать запрос, который выводит самый дорогой продукт.
select max(price) from product;

-- 5. Написать запрос, который выводит количество
-- всех продуктов определенного типа.
select name, amount from product;

-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select product.name
from product inner join type
on product.type_id = type.id
where type.name = 'Сыр' or type.name = 'Молоко';

-- 7. Написать запрос, который выводит тип продуктов,
-- которых осталось меньше 10 штук.
-- (сделал не 10, а меньше 2)
select type.name
from product inner join type
on  product.type_id = type.id
group by type.id
having count(type.id) < 2;

-- 8. Вывести все продукты и их тип.
select product.name, type.name
from product inner join type
on product.type_id = type.id;