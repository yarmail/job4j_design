package tdd;

/*
2. Что такое TDD? [#4918]
Программы мы пишем для клиентов.
Они диктуют требования, как программа должна работать.
Программист должен спроектировать программу так,
чтобы она выполняла все требования клиента.

Традиционные подходы разработки говорят программистом
писать сразу полезный код. Полезный код - это код, который
сразу выполняет требования клиента. Недостаток такого
подхода в том, что мы может ошибиться в дизайне.
Если такое произойдет, то нам нужно
переписать уже проверенный код. Делать редизайн.

Другой подход создания программы - это начать
описывать поведение системы через тесты. В таком подходе
мы фокусируемся на возможности системы, а не на ее реализацию.
Любую систему можно описать через интерфейсы взаимодействия.
Такой поход называется программирование через
тесты - Test Driven Development.

Реализация сервиса кинотеатр через TDD.

Рассмотрим требования клиента о создании сайта кинотеатра.
На сайте можно найти сеансы, и купить билеты.
Опишем нужные элементы системы.
Интерфейс сеанс - Session.
Интерфейс пользователь - Account.
Интерфейс билет - Ticket.

Интерфейс кинотеатра - Cinema.
Это основной интерфейс, на него сделагы тесты

Задание.
Посмотрите на созданные тесты. Опишите, каких тестов тут не хватает?
Допишите не достающие тесты. Классы реализовывать не нужно.
 */