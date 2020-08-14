package analizechange;

/**
 * Analysis of changes in a collection
 * Анализ изменений в коллекции
 * 2. Статистику по коллекции. [#293757]
 *
 * Это задание сводиться к определению разницы
 * между начальным состояние массива и измененным.
 * Например. Дан массива чисел. *
 * Начальное состояние 1 10 13 4 5
 * Конечное состояние 1 13 4
 * Разница будет будет массив 10 5.
 * Это элементарный пример. Ваша задача более сложная.
 *
 * Нужно реализовать класс.
 * public class Analize
 * метод
 * public Info diff
 * должен возвращать статистику о
 * б изменении коллекции.
 * List<User> previous - начальные данные,
 * List<User> current - измененные данные.
 *
 * Нужно понять:
 * Сколько добавлено новых пользователей.
 * Сколько изменено пользователей. Изменённым считается
 * объект в котором изменилось имя. а id осталось прежним.
 * Сколько удалено пользователей.
 *
 * Обязательно напишите тесты.
 */

/**
 * Варианты перевода в map
 *     Map <Integer, String> prevMap = previous.stream()
 *             .collect(Collectors.toMap(k -> k.getId(), v -> v.getName()));
 * ---------
 * Map<Integer, Boolean> answerMap = new HashMap<>();
 * for (Answer answer : answerList) {
 *     answerMap.put(answer.getId(), answer.getAnswer());
 *
 */
