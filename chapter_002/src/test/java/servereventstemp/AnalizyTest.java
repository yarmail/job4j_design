package servereventstemp;

import java.util.List;
import java.io.*;

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
        try (PrintWriter out = new PrintWriter(source)) {
            out.write("200 10:56:01\n" +
                         "500 10:57:01\n" +
                         "400 10:58:01\n" +
                         "200 10:59:01\n" +
                         "500 11:01:02\n" +
                         "200 11:02:02");
        }
        // Кажется интересным то, что в метод вместо файла подставляется String путь к этому файлу
        Analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());

        // target переводим в строку для проверки результатов
        StringBuilder rsl = new StringBuilder();
        try(BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is(
                "10:57:01;10:59:01\n" +
                      "11:01:02;11:02:02"));


    }



}