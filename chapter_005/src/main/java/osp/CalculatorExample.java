package osp;

import java.util.function.BiFunction;

/**
 * Допустим мне нужно будет добавить операцию вычитания
 * в программу. Для первого класса мне нужно будет
 * добавить еще метод, т.е. его изменить.
 *
 * Для второго
 * достаточно будет передать новую лямбду,
 * т.е. расширить программу, не изменяя ее.
 */
public class CalculatorExample {

    private static class SimpleCalculator {
        public int sum(int a, int b) {
            return a + b;
        }
    }

    private static class AbstractCalculator<T> {
        public T calculate(BiFunction<T, T, T> function, T first, T second) {
            return function.apply(first, second);
        }
    }
}