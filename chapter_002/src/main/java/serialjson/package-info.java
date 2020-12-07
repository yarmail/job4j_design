package serialjson;

/**
 *
 * 2. Формат JSON [#313164]
 * JSON (JavaScript Object Notation) – текстовый формат обмена данными, основан на синтаксисе JavaScript, удобен для написания и чтения человеком людьми. Несмотря на происхождение от JavaScript формат независим от него и может использоваться практически с любым языком программирования, для многих из которых существуют готовые библиотеки для создания и обработки данных в формате JSON.
 *
 * Применение:
 *
 * наиболее часто применяется для пересылки информации между браузером и сервером (загрузка контента по технологии Ajax) или между веб-сайтами (различные HTTP-соединения).
 * можно использовать везде, где требуется обмен данных между программами;
 * хранение локальной информации (например, настроек);
 * за счёт лаконичности может быть выбран для сериализации сложных структур вместо XML.
 * Примитивные типы данных в JSON:
 *
 * число (целое или вещественное).
 * литералы true, false и null.
 * строка —символы юникода, заключённые в двойные кавычки.
 * Ссылочные типы данных:
 *
 * Объект - заключается в фигурные скобки ({ и }) и содержит разделенный запятой список пар имя/значение.
 * Массив - заключается в квадратные скобки ([ и ]) и содержит разделенный запятой список значений.
 *
 * -----
 *
 * представление в формате JSON:
 *
 * {
 *
 *   "sex" : false, // пара «ключ: значение» с логическим типом
 *   "age" : 30, // пара «ключ: значение» с числовым типом
 *   " contact" : { // объект
 *   " phone " : " 11-111" // пара «ключ: значение» со строкой
 *   },
 *   "statuses":["Worker","Married"] // массив строк
 * }
 *
 *
 *
 * В java существует много библиотек для работы с json,
 * одни из наиболее популярных Jackson и Gson позволяют
 * преобразовывать json-строку сразу в объект и наоборот.
 * Рассмотрим на с библиотекой Gson.
 *
 *
 *
 */
