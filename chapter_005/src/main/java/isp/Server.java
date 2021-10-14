package isp;

/**
 * Правильный класс имплементирует
 * только нужные ему методы
 * Для этого интерфейсы должны
 * быть правильно разделены по методам
 */
public class Server implements Calculator, Internet {
    @Override
    public void calculate() {
        System.out.println("Do work!");
    }

    @Override
    public void connect() {
        System.out.println("Try connect ...");
    }
}
