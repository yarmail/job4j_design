package yagny;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * Здесь можно увидеть копирование кода.
 * Все методы повторяют друг друга и отличаются
 * только видом проверки.
 * Сделаем универсальный метод для поиска и
 * вынесем условие в аргумент метода.
 * Будет выглядеть примерно так
 */
public class SearchNew {

    static List<File> findBy(Predicate<File> predicate) {
        List<File> rsl = new ArrayList<>();
        /*
        for (File file : ..) {
            if (predicate.test(file)) {
                rsl.add(file);
            }
        }
        */
        return rsl;
    }
    static List<File> findByMask(String mask) {
        return findBy(file -> Pattern.matches(mask, file.getName()));
    }

    static List<File> findByName(String name) {
        return findBy(file -> file.getName().equals(name));
    }

    static List<File> findByExt(String ext) {
        return findBy(file -> file.getName().endsWith(ext));
    }
}
