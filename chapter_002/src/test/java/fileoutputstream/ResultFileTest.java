package fileoutputstream;

import java.io.FileOutputStream;

import org.junit.Ignore;
import org.junit.Test;


public class ResultFileTest {

    /**
     * Первый тест на "Hello, word" в файл "result.txt"
     * Тест работает, проверил и выключил
     */
    @Ignore
    @Test
    public void writeToFile() {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write("Hello, word".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}