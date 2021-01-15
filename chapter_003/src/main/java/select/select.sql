-- Примеры использования операторов

-- SELECT

-- извлекаем все поля из таблицы
select * from students;

-- запрос для извлечения только имени, курса и специальности студентов
select name, course, speciality from students;

-- студенты второго курса
select * from students where course = 2;

-- студенты всех курсов, кроме второго
select * from students where course != 2;

-- студенты, имя которых null
select * from students where name is null;

-- студенты, имя которых не null
select * from students where name is not null;

-- студенты, которые поступили после указанной даты
select * from students where enroll_date > '01.09.2019';

-- студенты старше 2 курса
select * from students where course > 2;

-------------------------

-- LIKE оператор сравнения строк

-- имя начинается c D
select * from students where name like 'D%';

-------------------------

-- Логические операторы AND, OR

-- имя начинается с D и курс больше 2
select * from students where name like 'D%' and course > 2;

-- имя начинается с D или курс больше 2
select * from students where name like 'D%' or course > 2;

-------------------------------

-- Работа с датами

-- текущая дата
select current_date;

-- проверка, что дата позже 10.09.2020
-- (выдает что-то не очень понятное, но в ячейке похоже на 'да')
select current_date > '10.09.2020';

-- прибавление единицы времени (day, week, month, year, hour)
select current_date + interval '1 month';

------------------------------

-- Упорядочивание выборки ORDER BY

-- упорядочивание выборки по возрастанию в колонке специальность
select * from students order by speciality asc;

-- по убыванию
select * from students order by speciality desc;

----------------

-- Выборка уникальных элементов SELECT DISTINCT
-- (выборка уникальных элементов одного столбца?)
select distinct course from students;

----------------

-- Выборка определенного числа элементов LIMIT
select * from students limit 5;