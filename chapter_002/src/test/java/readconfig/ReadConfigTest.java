package readconfig;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReadConfigTest {

    /**
     * Проверяем как работет метод load
     * т.е. как строки из файла заходят в map
     */
    @Test
    public void load() {
        String path = ".src/main/readconfig/app.properties";
        ReadConfig config = new ReadConfig(path);
        config.load();
        viewMap(config.getMap());
        //assertThat(config.value("name"), is("Petr Arsentev"));
    }

    private void viewMap(Map<String, String> map) {
        for (String name : map.keySet()) {
            System.out.println(name + ":" + map.get(name).toString());
        }

    }
}