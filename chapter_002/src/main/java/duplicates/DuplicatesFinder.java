package duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Клиент (тест)
 */
public class DuplicatesFinder {

    /**
     * Files.walkFileTree(Path.of("./"), new DuplicatesVisitor());
     * Запуск обхода с адреса, с условиями
     *
     * Thread.sleep(5000);
     */
    public static void main(String[] args) throws IOException {
        TestFilesOperations operations = new TestFilesOperations();
        Path sourcePath = operations.createTestFiles();
        DuplicatesVisitor duplicatesVisitor = new DuplicatesVisitor();
        Files.walkFileTree(sourcePath, duplicatesVisitor);
        duplicatesVisitor.getDuplicates().forEach(System.out::println);
        operations.deleteFiles(sourcePath);
    }
}