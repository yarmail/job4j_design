package foodstore.store;

import foodstore.Food;
import java.util.ArrayList;
import java.util.List;

/**
 * Мусор
 * Сюда направляются продукты с истекшим сроком годности
 * PercentFresh < 0 %
 */
public class Trash implements Store {
    private List<Food> store = new ArrayList<>();

    @Override
    public void add(Food food) {
        if (condition(food)) {
            store.add(food);
        }
    }

    @Override
    public boolean condition(Food food) {
        return food.getPercentFresh() < 0;
    }

    @Override
    public List<Food> getAll() {
        return store;
    }

    @Override
    public void clear() {
        store.clear();
    }
}