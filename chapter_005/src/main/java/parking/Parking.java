package parking;

/**
 * (Есть тесты)
 */
public class Parking {
    private int carSpace;
    private int truckSpace;

    /**
     * По условиям задачи Количество парковочных мест
     * для каждого типа машин задается на этапе создания парковки.
     * соответственно это можно сделать через конструктор
     */
    public Parking(int carSpace, int truckSpace) {
        this.carSpace = carSpace;
        this.truckSpace = truckSpace;
    }

    /**
     * Класс должен ответить на вопрос,
     * можно ли припарковаться или нет
     */
    boolean park(Transport transport) {
        return false;
    }
}
