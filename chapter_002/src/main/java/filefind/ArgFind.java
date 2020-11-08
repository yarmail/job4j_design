package filefind;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * java -jar find.jar -d c:/ -n *.txt -m -o log.txt
 */

public class ArgFind {

    private final String[] args;

    private Map<String, String> keys = new HashMap<>();

    public ArgFind(String[] args) {
        this.args = args;
    }

    public String getKey(String key) {
        return keys.get(key);
    }

    public boolean valid() {
        File file = new File(directory());
        return file.isDirectory();
    }

    public void setKey() {
        if (valid()) {
            keys.put("d", directory());
        } else {
            throw new IllegalArgumentException("The path is not a directory");
        }
        keys.put("o", output());
        keys.put("n", pattern());
        keys.put(searchType(), searchType());
    }

    public String directory() {
        String[] str = args[0].split(" ");
        if (str[4].isEmpty()) {
            throw new IllegalArgumentException("Define source directory");
        }
        return str[4];
    }

    public String pattern() {
        String[] str = args[0].split(" ");
        if (str[6].isEmpty()) {
            throw new IllegalArgumentException("Define name of files");
        }
        return str[6];
    }

    public String searchType() {
        String[] str = args[0].split(" ");
        str = str[7].split("");
        String name = str[1];
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Define how to find the file m - by mask of name *.txt,"
                    +
                    "f - by full name matches, r - by regex");
        }

        return name;
    }

    public String output() {
        String[] str = args[0].split(" ");
        if (str[9].isEmpty()) {
            throw new IllegalArgumentException("Define name of the output file");
        }
        return str[9];
    }
}