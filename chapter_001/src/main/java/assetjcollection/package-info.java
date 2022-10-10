package assetjcollection;

/*
Утверждения с коллекциями [#504885]

С использованием библиотеки AssertJ можно проверять
различные утверждения, связанные с содержанием коллекций.
При этом нет необходимости самостоятельно извлекать
из коллекции элементы для сравнения с ожидаемым результатом,
библиотека делает это за нас. Коллекция при этом должна
реализовывать интерфейс java.lang.Iterable<T>.

Создадим такую коллекцию SimpleCollection.
Так как нам нет необходимости проверять внутреннюю логику
помещения/извлечения элементов, реализуем
в коллекции только интерфейс Iterable.

---

Задание:
1. Создайте класс SimpleConvert.
2. Создайте тестовый класс SimpleConvertTest.
Добавьте тестовые методы на каждый метод класса SimpleConvertTest,
в которых покажите возможности проверки содержимого
коллекции и отдельных ее элементов.
 */