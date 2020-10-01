package readconfig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class ReadConfig {
    private final String path;
    private final Map<String, String> map = new HashMap<String, String>();

    public ReadConfig(final String path) {
        this.path = path;
    }

    public Map<String, String> getMap() {
        return map;
    }


    /**
     * Реализуйте метод load по аналогии с методом toString.
     * Метод load должен загружать пару ключ-значение в Map values.
     */
    public void load() {
        StringJoiner out = new StringJoiner(System.lineSeparator());

        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            String line;
            while ((line = read.readLine()) != null) {
                if (line.contains("=")) {
                    int indexSymbol = line.indexOf("=");
                    int length = line.length();
                    String key = line.substring(0, indexSymbol);
                    String value = line.substring(indexSymbol, length-1);
                    this.map.put(key, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Реализуйте метод value(String key)
     * он должен возвращать значение ключа.
     */
    public String value(String key) {
        return map.get(key);
    }

/*  пока не очень понял, зачем переопределять toString()
    public String toString() {
        //  к каждой считываемой строке добавляет разделитель ?
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReadConfig ("app.properties"));
    }
*/

}