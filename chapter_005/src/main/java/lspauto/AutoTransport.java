package lspauto;

/**
 * (теория в пакете lsp)
 * 1.
 * Предусловие - это условие, которое проверяет
 * корректность аргументов конструктора или метода.
 * Допустим у нас есть класс автотранспорта.
 *
 * public class AutoTransport
 *
 * if (fuel < 0) <= предусловие
 */
public class AutoTransport {
    protected float fuel;

    public AutoTransport(float fuel) {
        this.fuel = fuel;
    }

    public void move(float km) {
        if (km < 0) {
            throw new IllegalArgumentException("Invalid distance!");
        }
        if (fuel < 0) {
            throw new IllegalArgumentException("Need more fuel!");
        }
    }
}