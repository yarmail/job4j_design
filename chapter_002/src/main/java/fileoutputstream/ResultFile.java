package fileoutputstream;

import java.io.FileOutputStream;

/**
 * ТЕОРИЯ
 * Наша программа взаимодействует с внешними ресурсами.
 * Мы уже начали работать с такими ресурсами,
 * когда выводили информацию на консоль.
 * Консоль - это внешний приемник.
 * Такие ресурсы еще можно назвать источники или приемники данных.
 *
 * Консоль может быть приемником данных,
 * когда мы выводим через нее информацию пользователю.
 *
 * В то же время консоль может быть источником данных,
 * когда пользователь вводит данные в нее.??
 *
 * Файл - это источник данных и приемник.
 * В Java источник и приемник данных описаны через абстрактные классы.
 * java.io.InputStream
 * java.io.OutputStream
 * Напишем программу, которая записывает текст в файл.
 * Класс java.io.FileOutputStream позволяет записать данные в файл.
 */
public class ResultFile {
    /**
     * Здесь образец. Реальный запуск в тесте
     *
     * 1. Конструктор класса FileOutputStream принимает
     * имя файла. Файл будет создан в корне проекта.
     *
     * 2. Для записи используется метод out.write.
     * Этот метод принимает массив байт,
     * поэтому строку преобразовали в массив байтов.
     *
     * 3. Любой ресурс должен быть закрыт
     * для это используется конструкция try-with-resources.
     *
     */
    public static void writeToFile() {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write("Hello, word".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}