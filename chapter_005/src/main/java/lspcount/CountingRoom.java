package lspcount;

/**
 * 2. Постусловия (Postconditions) не могут быть ослаблены в подклассе.
 *
 * Постусловие - это условие, налагаемое на возвращаемое значение метода.
 *
 * Рассмотрим такой пример. Пусть есть бухгатерия, которая
 * считает по табелю сколько работник отработал
 * и если он отработал норму, то высчитывает для него зарплату.
 *
 * Далее мы наследуемся допустим для бугалтерии магазина.
 * (см class ShopCountingRoom)
 * В нем мы забываем про условие когда добавляем специфическое поведение
 * и когда запускаем пример, то получаем, что недобросовестный работник получает зарплату.
 */
class CountingRoom {
    protected int normHours;
    protected int payPerHour;

    public CountingRoom(int normHours, int payPerHour) {
        this.normHours = normHours;
        this.payPerHour = payPerHour;
    }

    public int pay(WorkDays workDays) {
        int factHours = 0;
        for (Integer hoursPerDay : workDays) {
            factHours += hoursPerDay;
        }
        if (factHours < normHours) {
            throw new IllegalArgumentException("Worker didn't work enough!");
        }
        return factHours * payPerHour;
    }
}