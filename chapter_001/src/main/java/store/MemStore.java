package store;

/**
 * Сделаем каркас универсального хранилища.
 */
import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    private int indexOf(String id) {
        int rsl = -1;
        for (int i = 0; i < this.mem.size(); i++) {
            if (this.mem.get(i).getId().equals(id)) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    @Override
    public void add(T model) {
        this.mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = this.indexOf(id);
        boolean rsl = false;
        if (index != -1) {
            this.mem.set(index, model);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean delete(String id) {
        int index = this.indexOf(id);
        boolean rsl = false;
        if (index != -1) {
            this.mem.remove(index);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public T findById(String id) {
        T rsl = null;
        int index = this.indexOf(id);
        if (index != -1) {
            rsl = this.mem.get(index);
        }
        return rsl;
    }
}
