package zipproject;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * validate according pattern
 * проверить согласно шаблону
 *"java -jar pack.jar -d=c:\project\job4j\ -e=class -o=project.zip"
 * Как я понимаю, в этой строке нам нужно извлечь
 * следующие параметры:
 * -d - directory - которую мы хотим архивировать
 * -e - exclude - исключить файлы *.xml
 * -o - output - во что мы архивируем - выходной файл
 */
public class ArgZip {
    private final String[] args;
    private Map<String, String> map = new HashMap<>();

    public ArgZip(String[] args) {
        this.args = args;
    }
// В этой части класса вычленяем параметры из строки аргументов
// и проводим некоторые проверки аргументов
    /**
     * Является ли путь директорией
     */
    public boolean valid() {
        File file = new File(directory());
        return file.isDirectory();
    }
    /**
     * Работаем с исходной папкой
     * Как я понимаю, в нашей задаче,
     * мы получаем не массив строк аргументов (как в реальности),
     * а одну строку arg[0] которую, в свою очередь,
     * нам нужно разбить на массив строк
     *
     * Далее, чтобы получить ключ и папку нам нужен 3 элемент массива
     * -d=c:\project\job4j\
     * мы разбиваем эту подстроку ещё раз на массив с двумя элементами
     * (разделитель знак =)
     * и проверяем, есть ли второй элемент
     *
     */
    public String directory() {
        String[] str = args[3].split("=");
        if (str[1].isEmpty()) {
            throw new IllegalArgumentException("Отсутствует путь к исходной папке");
        }
        return str[1];
    }
    /**
     * Работаем с параметром Исключить файлы по расширению
     * Выполняем операции, аналогичные работе с папкой
     *
     */
    public String exclude() {
        String[] str = args[4].split("=");
        if (str[1].isEmpty()) {
            throw new IllegalArgumentException("Отсутствует параметр Исключение файлов по расширению");
        }
        return str[1];
    }
    /**
     * Аналогично работаем с параметром выходного файла
     *
     */
    public String output() {
        String[] str = args[5].split("=");
        if (str[1].isEmpty()) {
            throw new IllegalArgumentException("Имя выходного файла не задано");
        }
        return str[1];
    }
// В этой части класса как в задании Именованные аргументы
// заполняем мапу и добавляем методы для работы с ней
    public void setValue() {
        map.put("d", directory());
        map.put("e", exclude());
        map.put("o", output());
    }
    public String getValue(String key) {
        return map.get(key);
    }
}