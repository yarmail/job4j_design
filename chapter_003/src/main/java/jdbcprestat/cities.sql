create table cities(
id serial primary key,
name text,
population int
);

-- как можно получить id
-- 1.  На чистом SQL. В SQL есть ключевое слово RETURNING(поля),
-- которое мы можем использовать в запросе. В итоге запрос вставки будет выглядеть так:
insert into cities(name, population) values ('Ufa', 1000000) returning (id);