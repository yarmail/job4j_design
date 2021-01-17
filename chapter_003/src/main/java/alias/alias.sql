-- Извлечем только имя, серию и номер
select pp.name, p.seria, p.number from people as pp join passport as p on pp.passport_id = p.id;

/*
Алиасы здесь:
people as pp
passport as p
 */

/*
иногда может понадобиться выбрать другое названия для столбцов результирующей выборки.
В в этом случае альясы используют с поля в select
 */
select pp.name as Имя, p.seria as Серия, p.number as Номер from people as pp join passport as p on pp.passport_id = p.id;
/*
Алиасы здесь:
pp.name as Имя
p.seria as Серия
p.number as Номер
passport as p
 */

/*
Результат
Имя Серия Номер
Ivan	1111	123456
Boris	1112	123457
Petr	1113	123458
 */