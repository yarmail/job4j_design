/*
Связь many-to-one
 */

-- У нас есть таблица должностей

/*
CREATE TABLE position (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255)
);
--*/

--------------------------

-- и таблица сотрудников

/*
CREATE TABLE employees (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  position_id INT REFERENCES position(id)
);
--*/

------------------------
/*
Особое внимание стоит уделить столбцу position_id.
Для связи таблиц между собой используется ключевое
слово REFERENCES. Это значит, что значения данного
столбца - значения связываемой таблицы.

В данном случае это можно трактовать как столбец
position_id содержит значения из таблицы positions,
а именно из столбца id. Общий синтаксис связи при
создании таблицы выглядит следующим образом:

имя_столбца тип REFERENCES связываемая_таб(столбец_св_табл)

Слово REFERENCES с английского переводится как "ссылается".
Что это значит?
 */

-- Добавим должность в Таблицу должностей

/*
INSERT INTO position(name) VALUES ('programmer');
--*/

------------------------------------------

-- Добавим работника с этой должностью

/*
INSERT INTO employees(name, position_id)
VALUES ('Ivan', 1);
--*/

-----------------------------------------
/*
SELECT * FROM employees;
--*/

-----------------------------

/*
Видим, что в таблице position_id стоит какое-то значение.
Мы можем перейти к соответствующей таблице, на которую
ссылаемся, и найти запись по этому столбцу.
Таким образом, мы как бы «переходим» по ссылке.
Через SQL это можно записать так
*/
/*
SELECT * FROM position WHERE id in
(SELECT id FROM employees);
--*/

--------------------------

/*
Обратите внимание, что стрелка идет от сущности,
которая many, к сущности, которая one.
Либо же можно рассуждать так: где у нас
стоит REFERENCES связь начинается,
а стрелка будет указывать на сущность,
на которую мы ссылаемся.
*/