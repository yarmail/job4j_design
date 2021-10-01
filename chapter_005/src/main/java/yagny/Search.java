package yagny;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * DRY - don't repeat yourselft. Дословно "не повторяй себя".
 * Противоположность этому принципу - copypaste.
 * То есть, старайтесь использовать уже существующие методы,
 * чтобы решить новую задачу. Не копируйте код.
 *
 * YAGNI - You aren't going need it.
 * Принцип пересекается со втором.
 * Подумайте, стоит ли создавать новый метод.
 * Можно ли решить задачу уже существующими методами.
 *
 * Давайте рассмотрим пример поиска файлов
 * в системе по критериям.
 *
 * Здесь можно увидеть копирование кода.
 * Все методы повторяют друг друга и отличаются
 * только видом проверки.
 */
public class Search {

    /*
    static List<File> findByMask(String mask) {
        List<File> rsl = new ArrayList<>();
        for (File file : ..) {
            if (Pattern.matches(mask, file.getName())) {
                rsl.add(file);
            }
        }
        return rsl;
    }

    static List<File> findByName(String name) {
        List<File> rsl = new ArrayList<>();
        for (File file : ..) {
            if (name.equals(file.getName())) {
                rsl.add(file);
            }
        }
        return rsl;
    }

    static List<File> findByExt(String ext) {
        List<File> rsl = new ArrayList<>();
        for (File file : ..) {
            if (file.getName().endWiths(ext)) {
                rsl.add(file);
            }
        }
        return rsl;
    }
     */
}