package srp;

/*
0. Принцип единственной ответственности [#4913]
Перейдем к рассмотрению SRP и соотнесем
его с другими принципами. Рассмотрим конкретный пример.
Допустим нам нужно написать класс,
который генерируют последовательность
случайных чисел и выводит ее.

Сперва мы выделяем абстракцию.
В нашем случае это будет интерфейс SequenceGenerator

Далее пишем реализацию SequenceGeneratorA.java

Давайте попробуем найти нарушения принципа SRP
1. Первое что приходит на ум, это то,
что реализации SequenceGenerator имеют различный функционал.
Они и умеют генерировать последовательность,
и выводить куда-либо.
А если нужно просто вывести?
А если нужно просто сгенерировать?
Клиенту придется реализовывать этот функционал.

Это результат некорректного выделения абстракции,
каждая абстракция должна отвечать только за
представления своего функционала,
что тоже можно косвенно отнести к принципу SRP.

В этом проявляется связь с принципом ISP. Разделим интерфейсы
и удалим строку
void print(List<T> numbers);
из интерфейса

Теперь реализации SequenceGenerator
будут выполнять только предназначенную им задачу,
не зависимо от вывода. Вывод будет зависеть от контекста.

Теперь реализация будет иметь такой вид
SimpleSequenceGenerator

Можно ли сказать, что есть нарушение принципа SRP?
На самом деле можно, дело в том, что данный класс знает:
1) Как создать генератор случайных чисел
2) Как его настроить. В данном случае используется
пустой конструктор, но ваши классы могут содержать
и сложные в построении классы, когда нужно знать,
что передавать в конструкторы
3) Как генерировать как бы это парадоксально не звучало бы.
Он знает какой метод нужно вызвать.
Этот пункт можно проигнорировать, но при расширении
программы вы будите замечать,
что логика самого генератора остается такой же –
меняются лишь зависимости.

В этом проявляется связь с принципом DIP –
ваши классы должны зависеть от абстракций,
а нет от реализаций.  Также здесь есть зависимость
с принципом OCP – по факту сам код генератор не расширяемый,
мы можем лишь создать новые реализации,
а это расширение относится к контексту,
где будет применяться генератор последовательности,
но не к самому генератору.

Чтобы решить эту проблему нужно выделить
еще одну абстракция – генератор чисел.
И сделать так чтобы генератор последовательности
зависел от генерации числа

(создаем интерфейс генератора NumberGenerator<T>)

 */