package jdbcprestat;

/**
 * jdbc - dml operation - insert, select, update, delete
 *
 * 0.2. PrepareStatement [#379307]
 * PrepareStatement. Данный класс в отличии от Statement
 * предназначен для DML операций – INSERT, SELECT, UPDATE, DELETE.
 *
 * Ранее мы сталкивались с методом execute() и говорили,
 * что он подходит для всего. Но иногда нам нужно получить
 * сколько строк вставилось, изменилось и удалилось
 * или получить объект для извлечения данных при select.
 * Для первой цели как используется executeUpdate(),
 * а для второй executeQuery().
 *
 * excuteUpdate() возвращает int – количество affected строк,
 * т.е. количество строк на которые оказал влияние запрос.
 *
 * executeQuery() возвращает ResultSet, который позволяет
 * пройтись по результатам select запроса.
 *
 * Можно провести аналогию:
 *
 * statement.execute(sql);
 * int count = statement.getUpdateCount();
 * // эквивалентно
 * int count = statement.executeUpdate(sql);
 *
 * statement.execute(sql);
 * ResultSet result = statement.getResultSet();
 * // эквивалентно
 * ResultSet result = statement.executeUpdate(sql);
 * Кстати, execute() возвращает boolean.
 * Если true, то мы можем получить ResultSet.
 * Если false, то мы можем получить количество affected строк.
 *
 * ---
 *
 * Передача аргументов в запрос
 * Главной отличительной чертой данного класса является то,
 * что с его помощью можно вставлять аргументы в запрос.
 * - удобным образом, т.к. для вставки
 * предназначены специальные методы.
 * - безопасным способом, т.е. без возможности
 * возникновения SQL injection (это когда наш код декомпилируют
 * и меняют его, тем самым появляется возможность
 * потери и утечки данных).
 *
 * Рассмотрим, как передаются аргументы.
 *
 * Вставка
 * Обратите внимание.
 * - места куда будут подставляться
 * аргументы обозначаются «?».
 * - для подстановки  аргументов используются методы вида
 * “setТип(позиция, аргумент)”.
 * - позиция аргумента считается как его порядковый номер,
 * а не как индекс, т.е. позиции начинаются с 1.
 *
 * Обновление
 * Обратите внимание.
 * - метод update() возвращает boolean, это нужно для того,
 * чтобы узнать произошло обновление или нет.
 * - чтобы узнать произошло само обновление мы используем
 * метод executeUpdate(), если это метод возвращает 0,
 * то значит оно не произошло, поэтому мы проверяем, что результат больше 0.
 *
 * Удаление аналогично коду обновления
 *
 * Получение элементов
 * Обратите внимание.
 * - ResultSet мы использовали вместе с try-with-resources.
 * - чтобы получить доступ к элементу записи используем
 * метод «getТип(имя_столбца)».
 * - чтобы сдвинуть курсор используется метод next(),
 * если он возвращает true, то сдвиг произошел и мы можем получить данные.
 *
 * Получение id вставленного элемента
 * Чаще всего id поддерживается на уровне БД.
 * Что если нам нужно получить какое id сгенерировала БД для нашей записи?
 * В первую очередь может встать вопрос, а зачем это нужно?
 * В сложных системах, где множество связей между сущностями,
 * иногда бывает нужным использовать этот id, чтобы, например обновить
 * другую таблицу или еще как-то.
 *
 * 1.  На чистом SQL. В SQL есть ключевое слово RETURNING(поля),
 * которое мы можем использовать в запросе.
 * В итоге запрос вставки будет выглядеть так:
 * insert into cities(name, population) values ('Ufa', 1000000) returning (id);
 *
 * 2. С использованием JDBC. Для того чтобы получить id нужно при создании
 * PrepareStatement вторым аргументом передать Statement.RETURNING_GENERATED_KEYS.
 * После как обычно выполнить запрос. Наконец, чтобы получить ключ нужно
 * вызвать метод getGeneratedKeys(). Давайте перепишем метод insert,
 * так чтобы он возвращал переданный city, только уже с проставленным id из БД.
 *
 *
 *
 */
