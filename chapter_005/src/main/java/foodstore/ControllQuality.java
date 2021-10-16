package foodstore;

import java.util.ArrayList;
import java.util.List;
import foodstore.store.Store;

/**
 * Контроль качества и распределеня продуктов
 * по хранилищам
 *
 * Контроль качества:
 * в классе Food определена свежесть сразу при создании объекта
 * в хранилищах поставлены фильтры для распределения
 *
 * Осталось просто направить продукты в хранилища и они сами
 * должны правильно распределиться
 */
public class ControllQuality {
    private List<Store> storeList;

    public ControllQuality(List<Store> storeList) {
        this.storeList = storeList;
    }

    /**
     * Распределяем продукты
     */
    public void distribute(Food food) {
        for (Store store: storeList) {
            store.add(food);
        }
    }

    public  void resort() {
        List<Food> foodList = new ArrayList<>();
        for (Store s: storeList) {
            foodList.addAll(s.getAll());
            s.clear();
        }
        foodList.forEach(this::distribute);
    }
}