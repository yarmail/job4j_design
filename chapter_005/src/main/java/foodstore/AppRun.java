package foodstore;

import java.util.List;
import foodstore.store.*;

/**
 * Класс для запуска и проверки
 */
public class AppRun {

    /**
     * Условия теста такие:
     * whiteBread - должен попасть в Shop без скидки
     * blackBread - должен попасть в Shop со скидкой
     * fish - должен попасть в Trash
     * cheese - должен попасть в Warehouse
     *
     * Напоминаю,что день now задан в Food и равен 20
     */
    public static void main(String[] args) {

        Food whiteBread = new Food("Белый хлеб", 1, 70, 100);
        Food blackBread = new Food("Черный хлеб", 1, 25, 200);
        Food fish = new Food("Селедка", 1, 19, 400);
        Food cheese = new Food("Гауди", 19, 100, 500);

        Shop shop = new Shop();
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();

        List<Food> foodList = List.of(whiteBread, blackBread, fish, cheese);
        List<Store> storeList = List.of(shop, trash, warehouse);

        ControllQuality controllQuality = new ControllQuality(storeList);

        for (Food food:foodList) {
            controllQuality.distribute(food);
        }
        printStorageConsistance(warehouse, trash, shop);
        controllQuality.resort();
        printStorageConsistance(warehouse, trash, shop);

    }

    /**
     * Проверка состояния хранилищ
     */
    private static void printStorageConsistance(Warehouse warehouse, Trash trash, Shop shop) {
        if (!shop.getAll().isEmpty()) {
            System.out.println("Shop consists of: ");
            shop.getAll().forEach(System.out::println);
        }
        if (!trash.getAll().isEmpty()) {
            System.out.println("Trash consists of: ");
            trash.getAll().forEach(System.out::println);
        }
        if (!warehouse.getAll().isEmpty()) {
            System.out.println("Warehouse consists of: ");
            warehouse.getAll().forEach(System.out::println);
        }
    }
}
/*
Out:
Shop consists of:
Food{name='Белый хлеб', createDate=1, expiryDate=70, price=100, discount=0, percentFresh=72}
Food{name='Черный хлеб', createDate=1, expiryDate=25, price=180, discount=20, percentFresh=20}
Trash consists of:
Food{name='Селедка', createDate=1, expiryDate=19, price=400, discount=0, percentFresh=-5}
Warehouse consists of:
Food{name='Гауди', createDate=19, expiryDate=100, price=500, discount=0, percentFresh=98}
 */