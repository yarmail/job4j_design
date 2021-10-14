package isp;

/**
 *  Обратите внимание, что у сервера нет устройств
 *  ввода/вывода. Но ему приходиться поддерживать
 *  интерфейс Device.
 */
class AServer implements AADevice {

    /**
     * ПОЛУЧАЕТСЯ ЛИШНИЙ МЕТОД
     */
    @Override
    public void in(String data) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void calculate() {
        System.out.println("Do some work!");
    }

    /**
     * ПОЛУЧАЕТСЯ ЛИШНИЙ МЕТОД
     */
    @Override
    public void output() {
        throw new UnsupportedOperationException();
    }
}