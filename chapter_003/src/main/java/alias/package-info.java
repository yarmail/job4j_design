package alias;

/**
 * Alias
 * Алиасы
 * Алиас – это сокращения (и псевдонимы). Алиасы мы можем
 * использовать для двух целей.
 *
 * Во-первых, вы наверное заметили, что чтобы нам
 * прописать условие в "on" нам нужно было писать
 * полностью название таблицы. Это не удобно,
 * особенно когда нужно извлечь только некоторые поля.
 *
 * Для сокращений мы можем использовать «as переменная»,
 * который стоит после таблицы.
 *
 * В предыдущем уроке мы уже ыидели один из вариантов сокращений
 *
 * select * from people inner join passport p on people.passport_id = p.id;
 *
 * Запись passport p вероятно означает, что вместо
 * passport мы можем использовать p (типа алиас)
 *
 * select pp.name, p.seria, p.number from people as pp join passport as p on pp.passport_id = p.id;
 * Алиасы здесь:
 * people as pp
 * passport as p
 *
 * Во-вторых, при выводе названия столбцов соответствуют
 * названиям столбцов из таблицы. Но иногда может
 * понадобиться выбрать другое названия для столбцов
 * результирующей выборки. В в этом случае альясы
 * используют с поля в select
 */