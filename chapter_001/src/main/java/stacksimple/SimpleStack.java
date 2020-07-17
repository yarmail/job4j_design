package stacksimple;

/**
 * Организация простого стека на основе односвязного списка
 *
 */
public class SimpleStack<T> {
    private ForwardLinked<T> list = new ForwardLinked<>();

    /**
     * Извлечение данных из стека
     * извлекается последний элемент
     * (верхняя тарелка)
     *
     * Метод pop() - должен возвращать значение
     * и удалять его из коллекции.
     *
     */
    public T pop() {
        return list.removeLast();
    }

    public void push(T value) {
        list.addLast(value);
    }

    /**
     * Метод для извлечения нижней первой тарелки
     * с её удалением
     *
     */
    public T poll() {
        return list.removeFirst();
    }
}