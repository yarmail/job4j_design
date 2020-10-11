package filescan;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import static java.nio.file.FileVisitResult.CONTINUE;


/**
 * Выполняем задание
 * Сканируем проект на наличие txt первым способом
 */
public class SearchB {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        search(start, "txt").forEach(System.out::println);
    }

    public static List<Path> search(Path root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();

    }
    public static class SearchFiles implements FileVisitor<Path> {
        private Predicate<Path> pathPredicate;
        private List<Path> listOfPath = new ArrayList<>();

        /**
         * В конструктор для поиска файлов добавляем уловия поиска
         *
         */
        public SearchFiles(Predicate<Path> pathPredicate) {
            this.pathPredicate = pathPredicate;
        }

        /**
         * По требованию возвращаем полученный список файлов
         */
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