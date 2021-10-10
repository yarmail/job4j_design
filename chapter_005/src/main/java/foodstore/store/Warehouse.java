package foodstore.store;

import foodstore.Food;
import java.util.ArrayList;
import java.util.List;

/**
 * Склад.
 * Сюда должны направлятся продукты
 * Если срок годности израсходован меньше чем на 25% (от 100 до 75)
 */
public class Warehouse implements Store {
    private List<Food> store = new ArrayList<>();

    @Override
    public void add(Food food) {
        if (condition(food)) {
            store.add(food);
        }
    }

    @Override
    public boolean condition(Food food) {
        return food.getPercentFresh() <= 100 && food.getPercentFresh() > 75;
    }

    @Override
    public List<Food> getAll() {
        return store;
    }
}