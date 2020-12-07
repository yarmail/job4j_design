package serialization;

/**
 * Сериализация – процесс преобразования объектов в бинарный
 * (т.е. последовательность битов) или текстовый формат.
 *
 * Десериализация – процесс преобразования
 * сериализованных данных в объекты, т.е.
 * операция обратная сериализации.
 *
 * Обычно механизм сериализации/десериализации используется
 * для сохранения состояния программы между запусками,
 * хранения настроек, передачи данных между программами
 * локально или по сети.
 *
 * В Java существует стандартный механизм сериализации
 * в бинарный формат – Java serialization, из текстовых
 * форматов наиболее популярны JSON, XML, YAML, BSON (binary JSON).
 *
 *  Java serialization. Для стандартной сериализации объекта
 *  необходимо в классе наследоваться от интерфейса
 *  Serializable, этот интерфейс является маркерным,
 *  т.е. нет необходимости реализовывать его методы,
 *  он сообщает JVM, что объект нашего класса может быть сериализован.
 *
 *  Для сериализации объектов в поток используется метод writeObject,
 *  для чтения из потока readObject класса ObjectOutputStream.
 *
 * Рассмотрим некоторые дополнительные замечания:
 *
 * - Поле serialVersionUID - уникальный идентификатор версии
 * сериализованного класса, необходим для обеспечения механизмов
 * версионности, т.е. нужен JVM для понимания, что сериализованный
 * объект при десериализации имеет те же члены класса, методы и пр.
 * Если значения не совпадают, будет выброшено исключение
 * java.io.InvalidClassException.
 * Для наглядности в примере мы задаем значение поля вручную,
 * в реальной разработке лучше использовать штатный
 * механизм Java генерации serialVersionUID или разработать свой.
 *
 * - При сериализации объекта сериализуются все объекты,
 * на которые он ссылается в своих полях, поэтому вложенные
 * объекты тоже должны быть Serializable.
 *
 * - Для исключения полей из сериализации используется
 * ключевое слово transient.
 * - С помощью интерфейса Externalizable можно реализовать
 * собственный алгоритм сериализации/десериализации,
 * для этого нужно переопределить два обязательных
 * метода — writeExternal() и readExternal().
 *
 */