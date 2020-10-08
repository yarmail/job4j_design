package servereventstemp;

import java.io.*;
import java.util.StringJoiner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalizyTest {

    @Rule
    public TemporaryFolder tmpFolder = new TemporaryFolder();

    @Test
    public void unavailableTest() throws IOException {
        File source = tmpFolder.newFile("source.txt");
        File target = tmpFolder.newFile("target.txt");
        String ls = System.lineSeparator();
        try (PrintWriter out = new PrintWriter(source)) {
            out.write("200 10:56:01"
                    + ls
                    +    "500 10:57:01"
                    + ls
                    +    "400 10:58:01"
                    + ls
                    +    "200 10:59:01"
                    + ls
                    +    "500 11:01:02"
                    + ls
                    +    "200 11:02:02");
        }
        // Кажется интересным то, что в метод вместо файла подставляется String путь к этому файлу
        Analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());

        // target переводим в строку для проверки результатов
        // НЕ ЗАБЫВАЕМ К КАЖДОЙ СЧИТЫВАЕМОЙ СТРОКЕ ДОБАВЛЯТЬ РАЗДЕЛИТЕЛЬ
        StringJoiner rsl = new StringJoiner(System.lineSeparator());
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::add);
        }
        assertThat(rsl.toString(), is(
                "10:57:01;10:59:01"
                  + ls
                  +   "11:01:02;11:02:02"));
    }
}