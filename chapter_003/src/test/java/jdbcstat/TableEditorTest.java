package jdbcstat;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


import java.io.InputStream;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

// Можно отключить пока не проработан вопрос подключения бд к тревису
@Ignore
public class TableEditorTest {
    private Properties properties = new Properties();


    @Before
    public void  getProperties() throws Exception {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        properties.load(is);
    }

    /**
     * Примечания:
     * Перед проведением повторного тестирования убедиться,
     * что таблицы не существует
     * drop table test cascade;
     *
     * Во время тестированя можно использовать проверку через
     * запрос:
     * select * from test;
     *
     * @throws Exception
     */
    @Test
    public void checkTableEditor() throws Exception {
        try (TableEditor tableEditor = new TableEditor(properties)) {
            tableEditor.createTable("test");
            tableEditor.addColumn("test", "column1", "text");
            tableEditor.addColumn("test", "column2", "text");
            tableEditor.addColumn("test", "column3", "text");
            tableEditor.renameColumn("test", "column3", "column_change");
            tableEditor.dropColumn("test", "column2");
            StringBuilder expected = new StringBuilder();
            expected.append(String.format("%-15s %-15s%n", "column", "type"));
            expected.append(String.format("%-15s %-15s%n", "column1", "text"));
            expected.append(String.format("%-15s %-15s%n", "column_change", "text"));
            assertThat(tableEditor.getScheme("test"), is(expected.toString()));

            // для наглядности проверки можно вывести в консоль
            System.out.println("Результат работы TableEditor");
            System.out.println(tableEditor.getScheme("test"));

            tableEditor.dropTable("test");
        }
    }
}