package filefind;

/**
 *
 * Search files by criterion
 * Поиск файлов по критерию [#293822]
 *
 * 1. Создать программу для поиска файла (файлов).
 * 2. Программа должна искать данные в заданном каталоге и подкаталогах.
 * 3. Имя файла может задаваться, целиком, по маске, по регулярному выражение(не обязательно).
 * 4. Программа должна собираться в jar и запускаться через java -jar find.jar -d c:/ -n *.txt -m -o log.txt
 * (главное, чтобы работала в IDEA)
 * Ключи
 * -d - директория в которая начинать поиск.
 * -n - имя файл, маска, либо регулярное выражение.
 *
 * -m - искать по маске, либо -f - полное совпадение имени. -r регулярное выражение.
 * (как я понимаю, (-m, -f, -r) определяет -n
 * -o - результат записать в файл.
 * 5. Программа должна записывать результат в файл.
 * 6. В программе должна быть валидация ключей и подсказка.
 *
 */
