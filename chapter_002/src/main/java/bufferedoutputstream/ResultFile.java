package bufferedoutputstream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Пример использования BufferedOutputStream
 */
public class ResultFile {
    public static void main(String[] args) {
            //Вторая обертка над буфером - это PrintWriter. Мы знаем, что будем записывать текст.
        try (PrintWriter out = new PrintWriter(
                //Это буфер, который собираем переданные в него байты
                new BufferedOutputStream(
                        new FileOutputStream("./chapter_002/src/main/java/bufferedoutputstream/result.txt")
                ))) {
            //Запись можно производить целыми строками.
            out.write("Hello, world!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
