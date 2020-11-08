package filefind;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import static java.nio.file.FileVisitResult.CONTINUE;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class FindAlgorithm {

    public List<Path> search(ArgFind argFind, Predicate<Path> condition) throws IOException {
        SearchFiles searchFiles = new SearchFiles(condition);
        Files.walkFileTree(Path.of(argFind.directory()), searchFiles);
        return searchFiles.getPaths();
    }

    public void saveLog(List<Path> paths, String outfile) throws IOException {
        Path tempDir = Files.createTempDirectory(null).toAbsolutePath();
        String pathLogFile = tempDir.resolve(outfile).toString();
        // для проверки выводим на консоль
        System.out.println(pathLogFile);
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(pathLogFile, Charset.forName("UTF-8"), true))) {
            for (Path path : paths) {
                //для проверки выводим на консоль
                System.out.println(path);
                //а потом записываем в файл
                bufferedWriter.write(path.toString() + System.lineSeparator());
            }
        }
            //после выполнения работы удаляем все временные файлы и папки
            Files.deleteIfExists(Paths.get(pathLogFile));
            Files.deleteIfExists(tempDir);

    }

    public static class SearchFiles extends SimpleFileVisitor<Path> {
        private List<Path> files = new ArrayList<>();
        private Predicate<Path> predicate;

        public SearchFiles(Predicate<Path> predicate) {
            this.predicate = predicate;
        }

        public List<Path> getPaths() {
            return files;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            if (predicate.test(file)) {
                files.add(file);
            }
            return CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        ArgFind argFind = new ArgFind(new String[]{"java -jar find.jar -d ./chapter_002 -n *.txt -m -o log.txt"});
        FindAlgorithm findAlgorithm = new FindAlgorithm();
        argFind.setKey();
        Predicate<Path> condition = ConditionFactory.newCondition(argFind);
        List<Path> paths = findAlgorithm.search(argFind, condition);
        findAlgorithm.saveLog(paths, argFind.getKey("o"));
    }
}