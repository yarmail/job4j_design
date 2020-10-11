package filescan;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * Пример из урока
 * Программa, которая выводит содержимое
 * всей директории включая вложенные директории
 * Как я понимаю, все файлы проекта
 * Здесь используется класс Path, а не File.
 * Path - это усовершенствованная модель File. Используйте Path.
 */
public class Search {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        Files.walkFileTree(start, new PrintFiles());
    }
}