package analizechange;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Analize {

    /**
     * Предполагаем, что id уникальны
     */
    public Info diff(List<User> previous, List<User> current) {

        Info result = new Info();
        Map<Integer, String> prevMap = new HashMap<>();
        Map<Integer, String> currMap = new HashMap<>();

        for (User user : previous) {
            prevMap.put(user.getId(), user.getName());
        }
        for (User user : current) {
            currMap.put(user.getId(), user.getName());
        }

        Iterator<Map.Entry<Integer, String>> iterator = prevMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, String> pair = iterator.next();
            Object key = pair.getKey();
            Object value = pair.getValue();
            //все одинаковые удаляем
            if (currMap.containsKey(key)
                    && currMap.containsValue(value)) {
                iterator.remove();
                currMap.remove(key);
            }
            //все измененные тоже удаляем и отмечаем как измененные
            if (currMap.containsKey(key)
                    && !currMap.containsValue(value)) {
                iterator.remove();
                currMap.remove(key);
                result.setChanged(result.getChanged() + 1);
            }
        }
        // те, которые остались в prev - Удаленные
        result.setDeleted(prevMap.size());

        // те, которые остались в сurr - Добавленные
        result.setAdded(currMap.size());
        return result;
    }
}