package parking;

/**
 * Логика парковки
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
     * метод должен ответить на вопрос,
     * можно ли припарковаться или нет
     * Идем от размера машины - выбираем ту или иную парковку
     */
    boolean park(Transport transport) {
        boolean result = false;
        if (transport.getSize() == 1 && this.carSpace > 0) {
            this.carSpace--;
            result = true;
        } else if (transport.getSize() > 1 && this.truckSpace > 0) {
            this.truckSpace--;
            result = true;
        } else if (transport.getSize() <= this.carSpace) {
            this.carSpace -= transport.getSize();
            result = true;
        }
        return result;
    }
}