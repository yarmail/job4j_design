package bufferedreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Теория
 * Перепишем код через буферизированные потоки.
 * Это наглядный пример использование шаблона Д Е К О Р А Т О Р.
 * Один поток оборачивается в другой.
 *
 * Обратите внимание мы заменили FileInputStream на FileReader.
 * Базовый поток - это поток байтов. Его можно обернуть в символьный потом, если мы знаем, что нам нужно читать текст.
 *
 * Символьные потоки позволяют читать сразу символы, а не байты.
 * Так же у буферизированного символьного потока есть
 * методы чтения целой строки.
 *
 * Если я правильно понимаю, BufferedReader читает строками
 */
public class ReadFile {

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader("./chapter_002/src/main/java/bufferedreader/input.txt"))) {
            List<String> lines = new ArrayList<>();
            in.lines().forEach(lines::add);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
