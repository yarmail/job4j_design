package typesoflinks;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * 3. Weak Reference
 * Объекты, на которые ссылаются слабые ссылки удаляются
 * сразу, если на них нет сильных или безопасных ссылок.
 *
 * Данный тип ссылок служит для реализации структур
 * для которых у одного значения типа может быть только один объект,
 * например пул строк, и объекты чаще всего используется
 * всего один раз, т.е. сохранили-получили-забыли.
 *
 * Пример,
 */
public class WeakDemo {

    /**
     * В первом методе за'null'ение сильной ссылки
     * приводит к удалению объекта и мы его также уже
     * не можем получить по слабой ссылке.
     */
    private static void example1() throws InterruptedException {
        Object object = new Object() {
            @Override
            protected void finalize() throws Throwable {
                System.out.println("Removed");
            }
        };
        WeakReference<Object> weak = new WeakReference<>(object);
        object = null;
        System.gc();
        TimeUnit.SECONDS.sleep(3);
        System.out.println(weak.get());

    }

    /**
     * Во втором методе мы создаем объект вообще
     * без сильных ссылки.
     * При вызове сборщика мусора они все удаляются.
     * Корректное использование этого
     * типа ссылок аналогично безопасным.
     *
     */
    private static void example2() throws InterruptedException {
        List<WeakReference<Object>> objects = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            objects.add(new WeakReference<Object>(new Object() {
                @Override
                protected void finalize() throws Throwable {
                    System.out.println("Removed!");
                }
            }));
        }
        System.gc();
        TimeUnit.SECONDS.sleep(3);
    }

    /**
     * ReferenceQueue
     * Все типы ссылок, за исключением сильных,
     * в Java являются наследниками класса Reference.
     * Все его наследники всегда попадают в ReferenceQueue,
     *
     * Это может происходить как явно (мы можем задать
     * свою очередь) или неявно (когда мы не задаем).
     * В нее попадают ссылки тех объектов, которые уже помечены
     * на удаление.
     *
     * Особенности ссылок WeakReference и PhantomReference
     * (будет рассмотрена позже) связаны с применением
     * очереди ссылок.
     *
     * Что касается особенности WeakReference, так это то,
     * что когда на объект уже нет сильных или безопасных
     * ссылок происходит за'null'ение слабой ссылки,
     * как в примере выше.
     *
     * Далее WearReference будет помещена в очередь ReferenceQueue
     * и мы можем, пока объект не удален физически,
     * получить его из этой очереди.
     *
     * В таком после удаления объект временно
     * можно получить из ReferenceQueue
     * Если закомментируем явный вызов сборщика мусора,
     * то мы увидим, что в очереди еще нет ничего,
     * т.к. само удаление еще не произошло.
     *
     */
    private static void example3() throws InterruptedException {
        Object object = new Object() {
            @Override
            protected void finalize() throws Throwable {
                System.out.println("Removed");
            }
        };
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        WeakReference<Object> weak = new WeakReference<>(object, queue);
        object = null;

        System.gc();

        TimeUnit.SECONDS.sleep(3);
        System.out.println("from link " + weak.get());
        System.out.println("from queue " + queue.poll());
    }


}
