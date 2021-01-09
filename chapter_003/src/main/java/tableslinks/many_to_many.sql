/*
Связь many-to-many
Если возникает симметрия при применении связи many-to-one к двум сущностям,
то такая связь называется many-to-many.

Пример:
Человек и Курс. Человек может проходить много курсов
(one-to-many), в то же время курс могут проходить
много человек (many-to-one).
*/

/*
Пример:
Создаем таблицу курсов, таблицу людей и связываем эти таблицы
между собой с помощью третьей таблицы.
*/

--/*
 CREATE TABLE students(
   id serial primary key,
   name varchar(255)
 );
--*/

--/*
CREATE TABLE courses(
  id serial primary key,
  name varchar(255)
);
--*/

--/*
CREATE TABLE students_courses(
  id serial primary key,
  student_id int references students(id),
  course_id int references courses(id)
);
--*/

/*
Как видно по коду, здесь идет двойное применение REFERENCES,
т.е. у нас есть два внешних ключа во вспомогательной таблице.
Один ссылается на таблицу курсов, другой на таблицу людей.
*/

-- Добавим несколько записей:
insert into students(name) values ('Ivan');
insert into students(name) values ('Kirill');
insert into students(name) values ('Roman');

insert into courses(name) values ('Java SE');
insert into courses(name) values ('Spring');
insert into courses(name) values ('Hibernate');

insert into students_courses(student_id, course_id) values (1, 1);
insert into students_courses(student_id, course_id) values (1, 2);
insert into students_courses(student_id, course_id) values (1, 3);
insert into students_courses(student_id, course_id) values (2, 1);
insert into students_courses(student_id, course_id) values (2, 2);
insert into students_courses(student_id, course_id) values (3, 3);


