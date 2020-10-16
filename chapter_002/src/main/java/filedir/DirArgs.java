package filedir;

import java.io.File;

/**
 * Изменим программу, чтобы начальная
 * папка передавалась через аргументы запуска.
 * Если вы запустите эту программу,
 * то она упадет с исключением.
 * Это происходит потому, что вы не указали аргументы.
 *
 * Откройте пункт Edit configuration
 * Добавьте путь в пункт Program arguments.(C:\)
 * Рис 1,2
 * После этого программа выполнится без ошибок.
 *
 *
 * Пользователь может забыть про эти параметры или вообще не знать про них.
 * Поэтому программа должна сообщить про эти параметры.
 *
 * Поэтому добавляем валидацию (проверку)
 * Если пользователь забыл указать параметры,
 * то в консоли он увидит в чем причина и как ее поправить.
 * Сообщение в консоли:
 * Exception in thread "main" java.lang.IllegalArgumentException:
 * Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.
 *
 *
 */
public class DirArgs {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        File file = new File(args[0]);
    }
}
