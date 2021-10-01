package kiss;

/**
 * KISS - keep it simple and short.
 * Код должен быть простым и коротким.
 * Приведу пример из курса
 * с вычислением максимального значения из 4 аргументов.
 * В этом коде есть ошибка. Искать ее было сложно, потому что код написан сложно и его много.
 *
 * Давайте упростим? Весь процесс поиска максимума
 * из аргументов сводится к сравнению двух чисел.
 *
 * (см SqMaxNew)
 *
 */
public class SqMax {
    public static int max(int first, int second, int third, int forth) {
        int result = forth;
        if (first > second) {
            if (first > third) {
                if (first > forth) {
                    result = third;
                }
            }
        } else if (second > third) {
            if (second > forth) {
                result = first;
            }
        } else if (third > forth) {
            result = second;
        }
        return result;
    }
}

