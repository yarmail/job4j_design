package analizechange;

import java.util.*;
import java.util.stream.Collectors;

public class Analize {
    /**
     * Способ 1
     */
    public Info diff(List<User> previous, List<User> current) {

        Info result = new Info();
        Map<Integer, String> currMap = current.stream()
                .collect(Collectors.toMap(User::getId, User::getName));
        for (User user: previous) {
            var key = user.getId();
            var value = user.getName();
            String valueMap = currMap.remove(key);
            // Удаленные
            if (valueMap == null) {
                result.setDeleted(result.getDeleted() + 1);
            }
            // Измененнные
            if (valueMap != null && valueMap != value) {
                result.setChanged(result.getChanged() + 1);
            }
        }
        // те, которые остались в сurr - Добавленные
        // другой вариант int added = current.size() + deleted - previous.size()
        result.setAdded(currMap.size());
        return result;
    }

    /**
     * Способ 2
     */
    public Info diffAnother(List<User> previous, List<User> current) {

        Info result = new Info();
        Map<Integer, String> currMap = current.stream()
                .collect(Collectors.toMap(User::getId, User::getName));

        for (User user: previous) {
            var key = user.getId();
            var value = user.getName();
            // 1) если во втором списке нет ключа, как в первом, значит он был Удаленный
            if (!currMap.containsKey(key)) {
                result.setDeleted(result.getDeleted() + 1);
            }
            // 2) удалем все одинаковые из второго списка, оставшиеся, там будут Добавленными
            if (currMap.containsKey(key)
                    && Objects.equals(currMap.get(key), value)) {
                currMap.remove(key);
            }
            // 3) все измененные тоже удаляем и отмечаем как Измененные
            // (если ключ есть в мапе и значения разные по этому ключу, то значит было изменение.)
            if (currMap.containsKey(key)
                    && !Objects.equals(currMap.get(key), value)) {
                currMap.remove(key);
                result.setChanged(result.getChanged() + 1);
            }
        }
        // те, которые остались в сurr - Добавленные
        // другой вариант int added = current.size() + deleted - previous.size()
        result.setAdded(currMap.size());
        return result;
    }
}