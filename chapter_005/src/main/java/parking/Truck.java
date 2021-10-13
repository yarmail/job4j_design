package parking;

/**
 * Из задачи:
 * Грузовая машина может разместиться на месте,
 * предназначенном для грузовых машин,
 * либо на N парковочных мест для легковых машин,
 * стоящих рядом.
 *
 * Значит, если она занимает места для легковых
 * машин, мы должны имет возможность указать
 * это при создании объекта:
 * Опишем это в конструкторе
 */
public class Truck implements Transport {
    private int size;

    public Truck(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}