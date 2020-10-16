package filescan;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * Задание из урока Валидация параметров запуска.
 * Программа должна запускаться с параметрами.
 * Первый параметр - начальная папка.
 * Второй параметр - расширение файлов, которые нужно искать.
 *
 * Отредактировать аргументы программы можно здесь:
 * Run -> Edit Сonfigurations (Сonfiguration -> Program arguments)
 *
 * Задаем следующие параметры (здесь указаны в кавычках)
 * 1) "."
 * 2) "txt"
 *
 * Запуск прошёл успешно, поведение программы не изменилось
 */

public class SearchArgs {

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            throw new IllegalArgumentException("Используйте 2 параметра - начальную папку и расширение, которое надо искать");
        }
        Path start = Paths.get(args[0]);
        search(start, args[1]).forEach(System.out::println);
    }

    public static List<Path> search(Path root, String ext) throws IOException {
        SearchB.SearchFiles searcher = new SearchB.SearchFiles(p -> p.toFile().getName().endsWith(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();

    }
    public static class SearchFiles implements FileVisitor<Path> {
        private Predicate<Path> pathPredicate;
        private List<Path> listOfPath = new ArrayList<>();

        public SearchFiles(Predicate<Path> pathPredicate) {
            this.pathPredicate = pathPredicate;
        }
        public List<Path> getPaths() {
            return this.listOfPath;
        }
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            return CONTINUE;
        }
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (pathPredicate.test(file)) {
                this.listOfPath.add(file);
            }
            return CONTINUE;
        }
        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return CONTINUE;
        }
        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return CONTINUE;
        }
    }
}