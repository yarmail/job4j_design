package isp;

/**
 * Попробуем спроектировать интерфейс устройста,
 * вот что получим. Обратите внимание, что у
 * сервера нет устройств ввода/вывода.
 * Но ему приходиться поддерживать интерфейс Device.
 */
public interface AADevice {
    void in(String data);
    void calculate();
    void output();
}