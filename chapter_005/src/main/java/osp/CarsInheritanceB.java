package osp;

import java.util.List;

/**
 * Теперь поступило требование, что некоторые машины
 * не издают звука. Как этот код можно расширить,
 * реализуя требование? Можно расширить за счет наследования,
 * создав новую сущность и добавив ее в список.
 */
public class CarsInheritanceB {

    private static class Car {
        public String sound() {
            return "beep-beep";
        }
    }

    private static class NoSoundCar extends Car {
        @Override
        public String sound() {
            return "";
        }
    }

    public static void main(String[] args) {
        List<Car> cars = List.of(new Car(), new Car(), new NoSoundCar());
        cars.forEach(Car::sound);
    }
}