package fileinputstream;

import java.io.FileInputStream;

/**
 * Конструкция
 * Данные считываются по байтам.
 * Здесь используется конструкция try-with-resources,
 * чтобы закрыть поток ввода.
 */

public class ReadFile {

    /**
     * Получившийся текст можно разить на строчки через метод String.split.
     * String[] lines = text.toString().split(System.lineSeparator());
     * for (String line : lines) {
     *     System.out.println(line);
     * }
     * Программа заработала, поле выполнения
     * задачи уберу лишний текстовый файл input.txt
     * (описание в package-info)
     *
     */
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("input.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}