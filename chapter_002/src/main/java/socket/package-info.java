package socket;

/**
 *
 * 0. Что такое Socket? [#293825]
 *
 * В этом уроке мы узнаем, как программы могут обмениваться данными.
 * Как люди обмениваются информацией? Они используют язык.
 * Эта статья написана на русском языке, если вы его знаете,
 * то можете понять о чем статья.
 *
 * Программы для этой цели используют протоколы.
 * Протокол - это инструкция, как передать данные
 * от одной программы к другой.
 *
 * Java используют протокол TCP/IP. Этот протокол имеет
 * возможность передать данные и подтвердить,
 * что они успешно дошли до получателя.
 *
 * Программа, которая начала общение, называется клиентом.
 * Программа, которая принимает общение, называется сервером.
 *
 * В качестве клиента мы будем использовать программу cURL.
 * Скачайте архив по ссылке https://curl.haxx.se/windows/
 *
 * ==================================
 *
 * Взаимодействие
 *
 * Взаимодействие.
 *
 * 1. Запустите класс EchoServer.
 * 2. Открой cmd в папке
 * cd c:\Tools\curl-7.69.0-win64-mingw\bin\
 *
 * 3. Выполните команду запроса.
 * curl -i http://localhost:9000/?msg=Hello
 *
 * Нормальный ответ сервера:
 * HTTP/1.1 200 OK
 *
 * Посмотрите в консоль IDEA.
 * Там можно увидеть информацию, которую отправил клиент.
 * Параметр -i указывает curl вывести всю информацию принятую от сервера.
 * Параметр http://localhost:9000/?msg=Hello - это адрес.
 * Он состоит из протокола http. Адреса localhost.
 * Порта 9000. Параметров запроса /?msg=Hello.
 *
 * На стороне сервера эти параметры можно получить.
 * Первая строчка содержит параметры запроса.
 *
 * ====================
 *
 * Задание
 * Если клиент отправлять запрос
 * http://localhost:9000/?msg=Bye
 * нужно завершить работу сервера.
 *
 *
 */