package lspauto;

/**
 * 2.
 * Пусть теперь есть наследник - автобус.
 * class Bus extends AutoTransport
 * Предположим ему нужно больше топлива,
 * чтобы сдвинуться с места
 *
 * if (fuel < 5) Условие усилино
 *
 */
class Bus extends AutoTransport {

    public Bus(float fuel) {
        super(fuel);
    }

    public void move(float km) {
        if (km < 0) {
            throw new IllegalArgumentException("Invalid distance!");
        }
        if (fuel < 5) {
            throw new IllegalArgumentException("Need more fuel!");
        }
    }
}
