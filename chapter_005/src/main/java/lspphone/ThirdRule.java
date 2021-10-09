package lspphone;

/**
 * Класс для запуска и проверки
 * main запускается нормально, это неправильно.
 */
public class ThirdRule {
    public static void main(String[] args) {
        Subscriber subscriber = new SomeOperatorSubscriber(
                new PhoneNumber(+1, 111, 111_111_111)
        );
        subscriber.setPhoneNumber(
                new PhoneNumber(-1, 111, 111_111_111)
        );
    }
}
