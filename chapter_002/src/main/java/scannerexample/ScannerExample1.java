package scannerexample;

import java.io.CharArrayReader;
import java.util.Scanner;

/**
 * Пример #1
 * Пусть надо из потока данных вычленить только числа.
 * Для этого можно воспользоваться Scanner следующим образом:
 * Обратите внимание, что здесь в качестве источника
 * мы указали одну из реализаций Reader - CharArrayReader.
 * Данная реализация позволяет читать данные из массива символов,
 * т.е. из временной памяти.
 *
 */
public class ScannerExample1 {
    public static void main(String[] args) {
        var ls = System.lineSeparator();
        var data = String.join(ls,
                "1 A 2",
                "3 4 B",
                "C 5 6"
        );
        var scanner = new Scanner(new CharArrayReader(data.toCharArray()));
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                System.out.print(scanner.nextInt());
                System.out.print(" ");
            } else {
                scanner.next();
            }
        }
    }
}