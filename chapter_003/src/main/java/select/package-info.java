package select;

/**
 * using select operator
 * использование оператора select
 *
 * 0. Видео [#293747]
 * 0. Видео [#6861]
 *
 * ОПЕРАТОР SELECT
 * В этом уроке мы поговорим о том, как извлекать данные из таблицы.
 * Для данной цели служит оператор select.
 *
 * Синтаксис оператора выглядит так:
 * select * from имя_таблицы; -- извлекает все поля
 * select поле1, поле2, … from имя_таблицы; -- извлекает только указанные поля
 *
 * ФИЛЬТРАЦИЯ
 * Для фильтрации используется оператор where. Посмотрим с чем его можно применять.
 * Операторы сравнения =, <, >, <=, >=, !=, is null, is not null
 * Операторы = и != служат для проверки на равенство.
 * Для проверки на null не используют = или !=.
 * Для этого есть конструкция is null или is not null
 * Операторы <, >, <=, >= можно использовать для сравнения чисел и дат
 *
 * ----------
 *
 * ОПЕРАТОР СРАВНЕНИЯ LIKE
 *
 * Если нам нужно проверить просто равенство строки,
 * то можно использовать =, если нам нужно проверить,
 * что строка начинается или кончается с определенного
 * префикса/суффикса, то можно использовать оператор LIKE.
 *
 * .. LIKE “%abc” – строка должна кончаться с “abc”
 * .. LIKE “abc%” – строка должна начинаться с “abc”
 * .. LIKE “%abc%” – строка должна содержать “abc”
 *
 * --------------
 *
 * Логические операторы AND, OR
 *
 * В Java для объединения логических условий мы используем && и ||,
 * аналогом их является AND и OR. *
 * select * from students where name like 'D%' and course > 2;
 * select * from students where name like 'D%' or course > 2;
 *
 * --------------------------
 *
 * Работа с датами
 *
 * Часто бывает нужным проверить на какое-то условие дату. Для работы с датами есть свой синтаксис.
 *
 * Примеры:
 * select current_date; -- получение текущей даты
 * select current_date > '10.09.2020'; -- проверка, что дата позже 10.09.2020
 *
 * -------------------------------
 *
 * Упорядочивание выборки ORDER BY
 *
 * Данный оператор нужен для того, чтобы выборка была упорядочена. Мы пишем
 * .. order by поле ASC|DESC ..
 * ASC – ascending (по возрастанию), DESC – descending (по убыванию)
 *
 * -----------------------------
 *
 * Выборка уникальных элементов SELECT DISTINCT
 *
 * Если нам нужно получить только уникальные элементы,
 * то нужно указать distinct после select.
 * (выборка уникальных элементов одного столбца?)
 * select distinct course from students;
 *
 * -------------------
 *
 * Выборка определенного числа элементов LIMIT
 * Данный метод работает аналогично методу limit() в стримах.
 * Оставляет указанное ему число строк.
 * Например:
 * select * from students limit 5;
 *
 *
 *
 *
 *
 *
 */