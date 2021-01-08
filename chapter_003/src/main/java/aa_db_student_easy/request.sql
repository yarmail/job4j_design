-- Создаем базу данных student
-- для проверки основных команд
/*
CREATE DATABASE student;
--*/

-------------------

/*
Создаем таблицу студентов со следуюшими полями:
id, имя, возраст, студент (да, нет)
*/
/*
CREATE TABLE student (
  id serial primary key,
  name varchar(255),
  age smallint,
  isstudent boolean
)
--*/

------------------

-- Заполняем таблицу студентов
/*
INSERT INTO student
  (name, age, isstudent)
VALUES
  ('Vasya', 25, true);
--*/

------------------

-- Проверяем ввод
/*
SELECT * FROM student;
--*/

------------------

-- Обновляем данные

/*
UPDATE student SET age = 28;
--*/
-- тут лучше указывать какого именно студента обновляете

-----------------

-- Опять проверяем что получилось

/*
SELECT * FROM student;
--*/

-----------------

-- удаляем таблицу (скорее данные из таблицы)

/*
DELETE FROM student;
--*/