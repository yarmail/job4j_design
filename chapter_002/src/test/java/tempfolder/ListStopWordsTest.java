package tempfolder;

import java.util.List;
import java.io.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ListStopWordsTest {

    /**
     * Чтобы создать файлы во временной директории,
     * нужно использовать класс org.unit.rules.TemporaryFolder.
     * Этот класс позволяет создавать файлы
     * и директории во временном каталоге.
     * После запуска теста файлы созданные
     * через TemporaryFolder будут удалены.
     * Теперь нам нет необходимости заботиться о мусоре,
     * который оставляет наш тест, потому что его уберет
     * класс  TemporaryFolder.
     */
    @Rule
    public TemporaryFolder tmpFolder = new TemporaryFolder();

    @Test
    public void drop() throws IOException {
        File source = tmpFolder.newFile("source.txt");
        File target = tmpFolder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("hello foolish dude");
        }
        ListStopWords.drop(source.getAbsolutePath(), target.getAbsolutePath(), List.of("foolish"));
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("hello dude "));
    }
}