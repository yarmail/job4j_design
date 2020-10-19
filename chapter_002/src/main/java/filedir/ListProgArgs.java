package filedir;

/**
 * Простенькая впомогательная программа,
 * показывающая все параметры запуска данной программы
 *
 * Отредактировать аргументы программы можно здесь:
 * Run -> Edit Сonfigurations (Сonfiguration -> Program arguments)
 *
 */
public class ListProgArgs {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        // Arrays.stream(args).forEach(System.out::println);
    }
}