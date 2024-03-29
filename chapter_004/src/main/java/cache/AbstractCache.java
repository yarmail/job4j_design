package cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Создать структуру данных типа кеш.
 * Кеш должен быть абстрактный.
 * То есть необходимо, что бы можно было задать
 * ключ получения объекта кеша и в случае,
 * если его нет в памяти,
 * задать поведение загрузки этого объекта в кеш.
 * --
 * Нельзя использовать объект абстрактного класса,
 * надо делать наследника.
 * --
 * Как я понимаю неабстрактные методы могут
 * использоваться наследниками напрямую (?)
 * --
 *
 *
 */
public abstract class AbstractCache<K, V> {

    /**
     * Как я понимаю, в кеше (в мапе) хранятся
     * ключ - это хеш имени файла?
     * значение - это ссылка на объект (какой?) текст файла?
     */
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    /**
     * создаем мягкую ссылку и записываем в мапу
     */
    public void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    /**
     * Метод get(), если данные есть их возвращает,
     * если нет то, грузит заново, вызывая метод load(),
     * и создает для них
     * Пробуем интересный вариант get
     * Map.getOrDefault(Object key, V defaultValue)
     */
    public V get(K key) {
        V result = cache.getOrDefault(key, new SoftReference<>(null)).get();
        if (result == null) {
            result = load(key);
            cache.put(key, new SoftReference<>(result));
        }
        return result;
    }

    /**
     * В данном случае используется классический паттерн
     * Абстрактная фабрика, в которой метод load
     * должен быть переопределен классами наследниками
     * в зависимостии от их необходимостей,
     * а методе get мы ничего не знаем и не хотим знать
     * о том, как именно будет загружаться объект
     *
     * Программа должна считывать текстовые файлы из системы
     * и выдавать текст при запросе имени файла.
     */
    protected  abstract V load(K key);
}
