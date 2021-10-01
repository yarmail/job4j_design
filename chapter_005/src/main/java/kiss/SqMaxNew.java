package kiss;

/**
 *  Давайте упростим? Весь процесс поиска максимума
 *  из аргументов сводится к сравнению двух чисел.
 * Добавим метод для вычисления максимума
 * из двух аргументов, а потом перепишем метод для 4 аргументов.
 */
public class SqMaxNew {

    public static int max(int left, int right) {
        return left > right ? left : right;
    }

    public static int max(int first, int second, int third, int forth) {
        return max(
                max(first, second),
                max(third, forth)
        );
    }
}