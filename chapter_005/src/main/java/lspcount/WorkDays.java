package lspcount;

import java.time.LocalDate;
import java.time.Month;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * 2. Постусловия (Postconditions) не могут быть
 * ослаблены в подклассе.
 *
 * Постусловие - это условие, налагаемое
 * на возвращаемое значение метода.
 *
 * Рассмотрим такой пример. Пусть есть бухгатерия,
 * которая считает по табелю сколько работник отработал
 * и если он отработал норму,
 * то высчитывает для него зарплату.
 *
 * WorkDays - это расчет рабочих дней? Табель?
 */
class WorkDays implements Iterable<Integer> {

    private Map<LocalDate, Integer> workDays = new LinkedHashMap<>();

    public void add(LocalDate date, int hours) {
        workDays.put(date, hours);
    }

    @Override
    public Iterator<Integer> iterator() {
        return workDays.values().iterator();
    }
}
