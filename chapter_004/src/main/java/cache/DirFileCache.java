package cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Создать программу, эмулирующую поведение данного кеша.
 * Программа должна считывать текстовые файлы из системы
 * и выдавать текст при запросе имени файла.
 * Если в кеше файла нет, кеш должен загрузить себе данные.
 * По умолчанию в кеше нет ни одного файла.
 * Текстовые файл должны лежать в одной директории.
 * Пример. Names.txt, Address.txt - файлы в системе.
 * При запросе по ключу Names.txt -
 * кеш должен вернуть содержимое файла Names.txt.
 */
public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

/**
 * java 11
 * Path.of(cachingDir, key) - превращается в путь к файлу
 *
 */
    @Override
    protected String load(String key) {
        String result = null;
        try {
            result = Files.readString(Path.of(cachingDir, key));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
