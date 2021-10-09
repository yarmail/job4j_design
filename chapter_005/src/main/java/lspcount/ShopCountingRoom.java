package lspcount;

/**
 * Далее мы наследуемся допустим для бугалтерии магазина.( от общей бухгалтерии)
 * В нем мы забываем про условие когда добавляем специфическое поведение
 * и когда запускаем пример, то получаем, что недобросовестный работник получает зарплату.
 * (то есть в данном случае переопределение со сменой условий это плохо)
 */
public class ShopCountingRoom extends CountingRoom {
    public ShopCountingRoom(int normHours, int payPerHour) {
        super(normHours, payPerHour);
    }
    @Override
    public int pay(WorkDays workDays) {
        int factHours = 0;
        for (Integer hoursPerDay : workDays) {
            factHours += hoursPerDay;
        }
        return factHours * payPerHour;
    }
}



