package typesoflinks;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 2. Soft Reference
 * Объекты, на которые ссылаются безопасные ссылки,
 * удаляются только если JVM не хватает памяти,
 * т.е. они могут пережить более одной сборки мусора.
 *
 * Данный тип ссылок подходит для реализации кэша
 * - такой структуры данных, при которой часть данных
 * запоминается, а потом часто переиспользуется.
 *
 * Например, можно запоминать данные из
 * файлов или тяжелых запросов.
 *
 * При нехватке памяти JVM может удалить объекты
 * по этим ссылкам, если на них нет сильных ссылок.
 *
 * Есть контракт для данного типа ссылок:
 * GC гарантировано удалит с кучи все объекты,
 * доступные только по soft-ссылке, перед тем как
 * бросит OutOfMemoryError
 */

public class SoftDemo {

    /**
     * В первом методе не смотря на то,
     * что мы за'null'уляем сильную ссылку,
     * на объект остается безопасная ссылки,
     * а это значит объект будет удален только
     * при нехватке памяти.
     */
    private static void example1() {
        Object strong = new Object();
        SoftReference<Object> soft = new SoftReference<>(strong);
        strong = null;
        System.out.println(soft.get());
    }

    /**
     * Во втором методе, мы создаем много объектов,
     * но на них ссылается безопасная ссылка.
     * Если мы при создании большое количество
     * объектов при малом хипе, мы увидим, что объекты
     * начнут удаляться, т.к. станем не хватать памяти.
     */
    private static void example2() {
        List<SoftReference<Object>> objects = new ArrayList<>();
        for (int i = 0; i < 100_000_000; i++) {
            objects.add(new SoftReference<Object>(new Object() {
                String value = String.valueOf(System.currentTimeMillis());

                @Override
                protected void finalize() throws Throwable {
                    System.out.println("Object removed!");
                }
            }));
        }
        System.gc();
        int liveObject = 0;
        for (SoftReference<Object> ref : objects) {
            Object object = ref.get();
            if (object != null) {
                liveObject++;
            }
        }
        System.out.println(liveObject);
    }

    /**
     * Корректным использованием безопасных ссылок
     * является сначала получение сильной ссылки на данные,
     * а потом работы с сильной ссылкой.
     *
     * Это гарантирует, что в интервалах получения
     * сильной ссылки из безопасной GC не затрет объект.
     * Это касается не только локальных переменных,
     * но и возвращаемых значений и аргументов.
     * Пример
     */
    private static void unsafe() {
        List<SoftReference<Object>> someData = new ArrayList<>();
        if (someData.get(0).get() != null) {
            System.out.println("do something");
        } else {
            System.out.println("do something");
        }
        System.out.println("do something");
        someData.get(0).get();
    }

    private static void safe() {
        List<SoftReference<Object>> someData = new ArrayList<>();
        Object strong = someData.get(0).get();
        if (strong != null) {
            System.out.println("do something");
        } else {
            System.out.println("do something");
        }
        // work with strong
    }
}
