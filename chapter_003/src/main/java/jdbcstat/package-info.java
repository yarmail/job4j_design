package jdbcstat;


/**
 *
 * 0.1. Statement [#379306]
 *
 * Для исполнения операций существуют специальные классы:
 * Statement, PrepareStatement. Сегодня мы поговорим про Statement.
 * Данный класс предназначен для исполнения операций типа DDL,
 * т.е. для создания, удаления, обновления таблиц/баз данных.
 *
 * Для его выполнения существуют 3 метода: execute(), executeUpdate(),
 * executeQuery(). Последние два мы пока опустим и поговорим
 * про них позже. В общем случае можно использовать
 * просто метод execute()
 *
 * Чтобы проверить, что таблица создалась давайте выведем ее схему,
 * а именно ее столбцы и их типы. Для этого напишем отдельный метод
 * getTableScheme
 *
 */
