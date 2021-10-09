package lspcount;

import java.time.LocalDate;
import java.time.Month;

/**
 * Запускной класс проверки
 *
 * В нем (ShopCountingRoom) мы забываем про условие,
 * когда добавляем специфическое поведение
 * и когда запускаем пример, то получаем,
 * что недобросовестный работник получает зарплату.
 */
public class SecondRule {
    public static void main(String[] args) {
        WorkDays workDays = new WorkDays();
        workDays.add(LocalDate.of(2020, Month.DECEMBER, 1), 8);
        workDays.add(LocalDate.of(2020, Month.DECEMBER, 2), 6);
        workDays.add(LocalDate.of(2020, Month.DECEMBER, 3), 7);

        CountingRoom countingRoom = new ShopCountingRoom(3 * 8, 500);
        System.out.println(countingRoom.pay(workDays));
    }
}
/*
Вывод: 10500
 */
