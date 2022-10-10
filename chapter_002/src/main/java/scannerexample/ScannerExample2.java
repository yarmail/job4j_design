package scannerexample;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 * Пример #2
 * Пусть надо из потока данных вычленить адреса почты,
 * которые разделены между собой
 * “, ”. Можно поступить так:
 */
public class ScannerExample2 {
    public static void main(String[] args) {
        var data = "empl1@mail.ru, empl2@mail.ru, empl3@mail.ru";
        var scanner = new Scanner(new ByteArrayInputStream(data.getBytes()))
                .useDelimiter(", ");
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}
