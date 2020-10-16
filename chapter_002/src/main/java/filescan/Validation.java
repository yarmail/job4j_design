package filescan;

/**
 * Пример валидации
 * Блок if - это валидация аргументов.
 * Если ее не выполнять, то программу будет падать
 * с ошибками не понятными для пользователя.
 */

public class Validation {

    public static void div(int first, int second) {
        if (second == 0) {
            throw new IllegalArgumentException("Div by o");
        }
            int result = first / second;
        }
    }