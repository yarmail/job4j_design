package filescan;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

public class PrintFiles implements FileVisitor<Path> {

    @Override
    // включает в себя набор методов, которые следует выполнить перед посещением текущей поддиректории.
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    // набор методов, которые следует выполнить во время посещения текущего файла
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        //Нас будет интересовать только visitFile. Java последовательно передает в него файлы, а программист их обрабатывает.
        //В данном случае выводит на печать полный путь
        System.out.println(file.toAbsolutePath());
        return CONTINUE;
    }

    @Override
    // Данный метод может пригодиться при ошибке доступа к файлу + он «умеет» пробрасывать Exception.
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return CONTINUE;
    }

    @Override
    // Все, что необходимо сделать после посещения директории, нужно перечислить в рамках перегрузки данного метода
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }
}