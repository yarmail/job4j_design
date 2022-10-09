package duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Здесь задаются условия поиска?
 */
public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    Map<FileProperty, List<Path>> map = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(attrs.size(), file.toFile().getName());
        map.putIfAbsent(fileProperty, new ArrayList<>());
        map.get(fileProperty).add(file.toAbsolutePath());
        return super.visitFile(file, attrs);
    }

    public List<Path> getDuplicates() {
        List<Path> duplicates = new ArrayList<>();
        map.values().stream()
                .filter(paths -> paths.size() > 1)
                .forEach(duplicates::addAll);
        return duplicates;
    }
}