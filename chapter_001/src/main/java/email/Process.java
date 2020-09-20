package email;

import java.util.*;

public class Process {
    /**
     * для вытягивания списков email по имени
     */
    private Map<String, HashSet<String>> copySource;

    public Map<String, HashSet<String>> getResult(Map<String, HashSet<String>> source) {
        copySource = source;
        Map<String, HashSet<String>> stage1 = stage1(source);
        Map<String, HashSet<String>> result = stage2(stage1);
        return result;

    }

    /**
     * В качестве ключей получаем уникальный список email
     * В качестве значений получаем списки user'ов где встречался email
     * Промежуточная таблица выглядит так:
     * aaa@bbb.ru=[user4],
     * ups@pisem.net=[user2, user4],
     * lol@mail.ru=[user1],
     * xxx@ya.ru=[user1],
     * vasya@pupkin.com=[user3],
     * foo@gmail.com=[user1, user2],
     * xyz@pisem.net=[user3, user5]
     *
     */
    private Map<String, HashSet<String>> stage1(Map<String, HashSet<String>> source) {
        Map<String, HashSet<String>> temp = new HashMap<>();
        for (String name : source.keySet()) {
            HashSet<String> emailsSource = source.get(name);
            for (String email : emailsSource) {
                if (!temp.containsKey(email)) {
                    HashSet<String> names = new HashSet<>();
                    names.add(name);
                    temp.put(email, names);
                } else {
                    HashSet<String> names = temp.get(email);
                    names.add(name);
                    temp.put(email, names);
                }
            }
        }
        return temp;
    }

    /**
     * Промежуточная таблица выглядит так:
     *  aaa@bbb.ru=[user4],
     *  ups@pisem.net=[user2, user4],
     *  lol@mail.ru=[user1],
     *  xxx@ya.ru=[user1],
     *  vasya@pupkin.com=[user3],
     *  foo@gmail.com=[user1, user2],
     *  xyz@pisem.net=[user3, user5]}
     *
     * Как я понимаю, логика должна быть такая (идем по юзерам):
     * Если в целевом списке нет такого юзера - добавляем
     * Пример: aaa@bbb.ru=[user4],
     * Однако, если идет вторым (и далее) в списке
     * ups@pisem.net=[user2, user4],
     * удаляем из целевого списка а все email передаем первому номеру
     *
     * 2 способ, удаляем и добавляем из копии исходника.
     * Примечание: Из перевернутой таблицы вытаскиваем имена
     */
    private Map<String, HashSet<String>> stage2(Map<String, HashSet<String>> source) {
        Map<String, HashSet<String>> result = new HashMap<>();
        for (String email: source.keySet()) {
            HashSet<String> names = source.get(email);
            // если в списке имен только один элемент
            if (names.size() == 1) {
                for (String name: names) {
                    if (!result.containsKey(name)) {
                        HashSet<String> emails = copySource.get(name);
                        result.put(name, emails);
                    }
                }
            } else {
                int numberEl = 0;
                String firstName = null;
                for (String name: names) {
                    numberEl++;
                    //работаем с первым элементом из списка
                    if (numberEl == 1) {
                        firstName = name;
                        if (!result.containsKey(firstName)) {
                            HashSet<String> emails = copySource.get(firstName);
                            result.put(name, emails);
                        }
                    //работаем с 2 и далее
                    } else {
                        if (!result.containsKey(name)) {
                            HashSet<String> emails = copySource.get(name);
                            HashSet<String> firstEmails = result.get(firstName);
                            firstEmails.addAll(emails);
                            result.put(firstName, firstEmails);
                        } else {
                            HashSet<String> emails = result.get(name);
                            HashSet<String> firstEmails = result.get(firstName);
                            firstEmails.addAll(emails);
                            result.put(firstName, firstEmails);
                            result.remove(name);
                        }
                    }
                }
            }
        }
        return result;
    }
}
