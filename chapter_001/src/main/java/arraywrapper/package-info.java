package arraywrapper;

/**
 * Need to make a wrapper over the array
 * Необходимо сделать обертку над массивом
 * 5.2.1. Реализовать SimpleArray<T> [#156]
 */

/**
 * Интерфейс Collection расширяет интерфейс Iterable.
 * Это означает, что все коллекции можно перебирать,
 * организовав цикл for в стиле for each
 */

/**
 * Для проверки индекса используйте метод Objects.checkIndex
 * В методах, где используется индекс нужно делать валидацию.
 * Этот метод используется для проверки,
 * находится ли индекс в пределах заданной длины.
 * Возвращает индекс, если 0 ⇐ index <length .
 * В противном случае он генерирует исключение IndexOutOfBoundsException
 *
 * При использовании checkIndex нужно проверять в рамках добавленных.
 * Должно быть: Objects.checkIndex(index, position);
 *
 * Исключение которое кидает checkIndex обрабатывать не нужно,
 * потому что эта ошибка не касается контейнера.
 * Это ошибка того, кто его использует
 */
//////////////////////////////////////////////////////////
/**
 * Simple implementation of ArrayList
 * Простая реализация ArrayList
 * 1. Динамический список на массиве. [#293763]
 * В отличие от ArrayWrapper добавляем сюда
 * реализацию fail-fast поведения
 *
 */
