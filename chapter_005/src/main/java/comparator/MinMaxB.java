package comparator;

import java.util.Comparator;
import java.util.List;

/**
 * 1. Принципы Kiss, Dry и Yagni [#238813]
 * Разработайте класс для поиска максимального
 * и минимального элемента по критерию java.util.Comparator.
 */
public class MinMaxB {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return maxMin(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return maxMin(value, comparator.reversed());
    }

    public <T> T maxMin(List<T> value, Comparator<T> comparator) {
        T count = value.get(0);
        for (T index : value) {
            if (comparator.compare(index, count) > 0) {
                count = index;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinMaxB maxMin = new MinMaxB();
        List<Integer> list = List.of(4, 7, 2, 8, 3, 10);
        System.out.println(maxMin.min(list, Integer::compareTo));
        System.out.println(maxMin.max(list, Integer::compareTo));
    }
}