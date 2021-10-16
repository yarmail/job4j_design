package foodstore.store;

import foodstore.Food;
import java.util.ArrayList;
import java.util.List;

/**
 * Магазин.
 * Шкала уменьшается от 100% свежести до 0%
 * Сюда должны попадать продукты:
 * 1. Если срок годности  < 75 и >= 25
 * 2. Если срок годности < 25 % свежести выставить дисконт
 * скидку на продукт
 */
public class Shop implements Store {
    private List<Food> store = new ArrayList<>();

    @Override
    public void add(Food food) {
        if (condition(food)) {
            if (conditionDiscount(food)) {
                food.setDiscount(food.getDiscount() + 20);
                food.setPrice(food.getPrice() - food.getDiscount());
            }
            store.add(food);
        }
    }

    @Override
    public boolean condition(Food food) {
        return food.getPercentFresh() <= 75 && food.getPercentFresh() > 0;
    }

    public boolean conditionDiscount(Food food) {
        return food.getPercentFresh() <= 25 && food.getPercentFresh() > 0;
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