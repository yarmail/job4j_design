package gcdemo;

import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;

public class User {

    @Override
    protected void finalize() throws Throwable {
        System.out.print("Объект удален");
    }

    public static void main(String[] args) throws InterruptedException {
        User user = new User();
        System.out.printf("size of User = %d\n", sizeOf(user));
    }
}

/* Вывод
size of User = 16

Вопросы 4 и 5.
Сборщик мусора вызывается, когда за счет маленького размера памяти
(заданного ключами) память заполняется. Также можно попросить
JVM сделать это раньше, с помощью System.gc(), но не факт, что
это получится
 */
