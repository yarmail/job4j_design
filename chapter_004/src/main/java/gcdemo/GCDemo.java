package gcdemo;

public class GCDemo {

    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %d%n", freeMemory / MB);
        System.out.printf("Total: %d%n", totalMemory / MB);
        System.out.printf("Max: %d%n", maxMemory / MB);
    }

    /**
     * Можно ли как-то вызвать сборку мусора из кода?
     * Да, можно. Но виртуальная машина может это
     * проигнорировать. Чтобы вызвать сборку мусора нужно
     * написать
     * System.gc()
     * Вставьте эту строку после цикла
     */
    public static void main(String[] args) {
        info();
        for (int i = 0; i < 10000; i++) {
            new Person(i, "N" + i);
        }
        System.gc();
        info();
    }
}

/* Результат
=== Environment state ===
Free: 534
Total: 536
Max: 8577
=== Environment state ===
Free: 12
Total: 14
Max: 8577
Removed 5333 N5333
Removed 4003 N4003
*/
