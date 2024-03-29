package isp;

/*
ISP (Interface Segregation Principle)
0. Принцип разделения интерфейсов [#4916]

В этом уроке мы рассмотрим, пожалуй самый простой
для понимания принцип среди SOLID -
принцип ISP (Interface Segregation Principle),
принцип разделения интерфейсов.

Роберт Мартин точно высказал суть этого принципа:
"Программные сущности не должны зависеть от методов,
которые они не используют."

Давайте разберемся когда же сущности зависят
от методов, которые они не используют.
В первую чем стоит разобраться, так это то, что в
названии сидит слово "Interface". Можно догаться,
что если добавить много методов в интерфейс, то придеться
в реализациях все методы реализовывать,
хотя это не всегда уместно.

Пример, попробуем спроектировать интерфейс устройства
AADevice

(на А - неправильные классы, без A - правильные)

А что если нам нужно добавить метод подключения
к интернету connect().
Во-первых, нам придется реализовать его
в существующих классах,
Во-вторых, опять может возникнуть ситуация,
что не все устройства поддерживают подключение к интернету

Какое здесь решение? Разделение интерфейсов,
причем нам нужно подписать под нужные
интерфейсы только нужные реализации.
Например, для сервера только Calculator, Internet

ВЫВОД:
1. Наличие более 3 методов в интерфейсе
может быть признаком нарушение ISP
2. Некорректное выделение абстракций
ведет к нарушению всех методов SOLID включая ISP
3. Решение разделение интерфейсов на более мелкие
 */