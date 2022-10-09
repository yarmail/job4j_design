package duplicates;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

/**
 * Создаем тестовую среду
 */
public class TestFilesOperations {

    public Path createTestFiles() throws IOException {
        Path sourcePath = Files.createTempDirectory("test");
        String sourceStr = sourcePath.toString();

        Path pathDir1 = Paths.get(sourceStr, "dir1");
        Path pathDir2 = Paths.get(sourceStr, "dir2");
        Path pathDir3 = Paths.get(sourceStr, "dir3");
        Path pathDir4 = Paths.get(sourceStr, "dir4");
        Path pathDir5 = Paths.get(sourceStr, "dir5");
        List<Path> paths = List.of(pathDir1, pathDir2,
                pathDir3, pathDir4, pathDir5);
        for (Path path : paths) {
            Files.createDirectories(path);
        }

        Path pathFile1 = pathDir1.resolve("findMe.txt");
        Path pathFile2 = pathDir2.resolve("file2.txt");
        Path pathFile3 = pathDir3.resolve("findMe.txt");
        Path pathFile4 = pathDir4.resolve("file4.txt");
        Path pathFile5 = pathDir5.resolve("findMe.txt");
        paths = List.of(pathFile1, pathFile2,
                pathFile3, pathFile4, pathFile5);
        for (Path path: paths) {
                if (Files.notExists(path)) {
                    Files.createFile(path);
            }
        }
        return sourcePath;
    }

    public void deleteFiles(Path path) throws IOException {
        Files.walk(path)
                .map(Path::toFile)
                .sorted(Comparator.reverseOrder())
                .forEach(File::delete);
        Files.deleteIfExists(path);
    }
}