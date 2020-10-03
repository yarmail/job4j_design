package bufferedoutputstream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Задание
 * Нужно добавить метод save(String log).
 * Метод должен записывать результат фильтрации в файл.
 */

public class LogFilter {
    private static List<String> filter(String file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            in.lines()
                    .filter(str -> str.contains("404"))
                    .forEach(lines::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static void save(List<String> log, String file) {
        //Вторая обертка над буфером - это PrintWriter. Мы знаем, что будем записывать текст.
        try (PrintWriter out = new PrintWriter(
                //Это буфер, который собираем переданные в него байты
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            //Запись можно производить целыми строками.
            //out.write("Hello, world!");
            log.forEach(value -> out.write(value + System.lineSeparator()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        List<String> log = filter("./chapter_002/src/main/java/bufferedoutputstream/log.txt");
        save(log, "./chapter_002/src/main/java/bufferedoutputstream/404.txt");
    }
}