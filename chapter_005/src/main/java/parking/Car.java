package parking;

/**
 * По у словию задачи у легковой машины размер 1
 */
public class Car implements Transport {
    private int size = 1;
    @Override
    public int getSize() {
        return this.size;
    }
}
