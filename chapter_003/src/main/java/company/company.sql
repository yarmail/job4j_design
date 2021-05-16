
-- создаем таблицы
create table company (
  id integer not null,
  name character varying,
  constraint company_pkey primary key (id)
);

create table person (
  id integer not null,
  name character varying,
  company_id integer references company (id),
  constraint person_pkey primary key (id)
);

-- заполняем таблицы
insert into company values
(1, 'company1'),
(2, 'company2'),
(3, 'company3'),
(4, 'company4'),
(5, 'company5');

insert into person values
(1, 'name1', 1),
(2, 'name2', 1),
(3, 'name3', 1),
(4, 'name4', 1),
(5, 'name5', 1),

(6, 'name6', 2),
(7, 'name7', 2),
(8, 'name8', 2),
(9, 'name9', 2),

(10, 'name10', 3),
(11, 'name11', 3),
(12, 'name12', 3),

(13, 'name13', 4),
(14, 'name14', 4),

(15, 'name15', 5);

-- Выполняем запросы
/*
1) В одном запросе получить
- имена всех person, которые не состоят в компании с id = 5;
- название компании для каждого человека.
*/
select person.name, company.name
from person inner join company on person.company_id = company.id
where company.id != 5;

-- Ответ: все кроме name15

/*
2. Необходимо выбрать название компании с максимальным
количеством человек + количество человек в этой компании.
*/
select company.name, count(person)
from company inner join person on person.company_id = company.id
group by company.name
order by count(person) desc
limit 1;

-- Ответ company1  5 --