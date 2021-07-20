package cache;

import java.lang.ref.SoftReference;
import java.nio.file.Path;

/**
 * Создать класс Emulator для работы с пользователем.
 * Предоставить пользователю возможности:
 * - указать кэшируемую директорию
 * - загрузить содержимое файла в кэш (получить в мапе мягкую ссылку?)
 * - получить содержимое файла из кэша
 *
 * Короче это тестирование других  классов
 */
public class Emulator {

    public static void main(String[] args) {
        // задаем папку для хранения файлов в которой уже находятся наши контрольные файлы
        String dir = Path.of("chapter_004", "src", "main", "resources").toString();
        DirFileCache dirFileCache = new DirFileCache(dir);
        //Предположим user выбирает файл Address.txt. Получаем мягкую ссылку от нужного файла и заносим её в мапу
        dirFileCache.get("Address.txt");
        //Получаем из мапы мягкую ссылку
        SoftReference<String> softReference = dirFileCache.cache.get("Address.txt");
        //пробуем по мягкой ссылке получить текст файла
        System.out.println(softReference.get());
        //вроде бы все получилось хорошо
    }
}