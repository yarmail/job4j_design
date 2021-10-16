package foodstore.store;

import foodstore.Food;

import java.util.List;

/**
 * Модель хранилища
 * condition - для проверки условий попадания в хранилище
 * add - для добавления в хранилище
 * getALL - для проверки, сколько и каких объектов находится в хранилище
 * clear - для очистки хранилищ при выполнении команды resort
 */
public interface Store {
    void add(Food food);
    boolean condition(Food food);
    List<Food> getAll();
    void clear();
}