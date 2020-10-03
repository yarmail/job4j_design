package fileoutputstream;

import java.io.FileOutputStream;


/**
 * Задание - таблицу умножения вывести в файл
 */
public class MultiTableToFile {

    /**
     * Вывод в файл
     *
     */
    public static void writeToFile(int size) {
        String str = multiple(size);
        try (FileOutputStream out = new FileOutputStream("../chapter_002/src/main/java/fileoutputstream/result.txt")) {
            out.write(str.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * расчет таблицы умножения для заданного числа
     * и перевод в буфер
     *
     * @return
     */
    private static String multiple(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(((i + 1) * (j + 1)) + " ");
            }
            sb.append("\n");
        }
        String str = sb.toString();
        return str;
    }
}