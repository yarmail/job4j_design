package osp;

import java.util.List;

/**
 * Пример из главы Механизмы расширения
 * Расширение как правило достигается созданием
 * новых сущностей. Тут мы ярко можем увидеть
 * полиморфизм. Таким образом, расширение
 * достигается за счет полиморфизма.
 * А за счет чего достигается полиморфизм?
 *
 * Наследование
 *
 * Пусть изначально был написан такой код
 *
 */
public class CarsInheritanceA {

    private static class Car {
        public String sound() {
            return "beep-beep";
        }
    }

    public static void main(String[] args) {
        List<Car> cars = List.of(new Car(), new Car());
        cars.forEach(Car::sound);
    }
}
