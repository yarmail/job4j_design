package zipproject;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    /**
     * Метод для упаковки папки
     * Архив должен сохранять структуру проекта.
     * То есть содержать подпапки.
     */
    public void packFiles(List<Path> sources, File target) throws IOException {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            Iterator<Path> it = sources.iterator();
            while (it.hasNext()) {
                zip.putNextEntry(new ZipEntry(it.next().toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(it.next().toFile()))) {
                    zip.write(out.readAllBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * Пример метод для упаковки одного файла
     */
    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * В качестве параметров запуска я выбрал следующую строку
     * "java -jar pack.jar -d=./chapter_002 -e=txt -o=./chapter_002/src/main/java/zipproject/chapter_002.zip"
     * Сответственно у меня должно получиться:
     * args[0] = "java"
     * args[1] = "-jar"
     * args[2] = "pack.jar"
     * args[3] = "-d=./chapter_002"
     * args[4] = "-e=txt"
     * args[5] = "-o=./chapter_002/src/main/java/zipproject/chapter_002.zip"
     *
     */
    public static void main(String[] args) throws IOException {

/* пример упаковки одного файла
        new Zip().packSingleFile(
                new File("./chapter_002/pom.xml"),
                new File("./chapter_002/pom.zip")
        );
*/

    ArgZip argZip = new ArgZip(args);
    argZip.setValue();
    List<Path> paths = SimpleSearch.search(Paths.get(argZip.getValue("d")), argZip.getValue("e"));
    new Zip().packFiles(paths, new File(argZip.getValue("o")));
    }
}