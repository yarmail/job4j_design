package typesoflinks;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;


/**
 * Фантомный тип ссылок имеет две особенности:
 * 1) Метод get() всегда возвращает null, поэтому
 * доступ можно осуществить только через ReferenceQueue
 *
 * 2) PhantomReference попадает в ReferenceQueue
 * только после выполнения finalize(),
 * что значит мы еще имеем доступ к объекту некоторое время.
 *
 * Данный тип ссылки используется для более
 * гибкого управления удалением объектов,
 * минуя минусы finalize()
 * (будут описаны в статье по первой ссылки)
 *
 * Проведем такой эксперимент:
 * Для начала создаем класс наследующийся от
 * PhantomReference и переопределяем get(),
 * чтобы проконтролировать что удаляется наш ресурс.
 *
 * Создаем хранилище. В нем есть очередь, которая
 * необходима для ссылок.  Но эта очередь read-only,
 * поэтому создаем свой список и в него помещаем
 * наши фантомные ссылки. Когда вызывает метод для
 * утилизации ресурсов мы проверяем если ссылка в очереди,
 * т.е. помечен ли объект на удаление. Далее вызываем метод
 * явно clear(), что указать GC, что нужно удалить
 * объект в будущем и удаляем из нашего списка.
 */
public class PhantomDemo {

    private static class MyPhantom extends PhantomReference<String> {

        private String name;

        public MyPhantom(String referent, ReferenceQueue<? super String> q, String name) {
            super(referent, q);
            this.name = name;
        }

        @Override
        public String get() {
            return name;
        }
    }

    private static class PhantomStorage {

        private ReferenceQueue<String> queue = new ReferenceQueue<>();

        private List<MyPhantom> phantoms = new LinkedList<>();

        public void add(String someData) {
            MyPhantom phantom = new MyPhantom(someData, queue, "my ref");
            phantoms.add(phantom);
        }

        public void utilizeResource() {
            for (ListIterator<MyPhantom> i = phantoms.listIterator(); i.hasNext();) {
                MyPhantom current = i.next();
                if (current != null && current.isEnqueued()) {
                    System.out.println("Utilized " + current.get());
                    current.clear();
                    i.remove();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PhantomStorage storage = new PhantomStorage();
        String data = "123".repeat(1000);
        storage.add(data);
        data = null;
        System.gc();
        TimeUnit.SECONDS.sleep(3);
        storage.utilizeResource();
    }

}
