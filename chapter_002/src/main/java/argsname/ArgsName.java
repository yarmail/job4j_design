package argsname;

import java.util.HashMap;
import java.util.Map;


/**
 * Пример возможной строки параметров "java -Xmx=514 -encoding=UTF-8"
 */
public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    /**
     * Принцип работы такой:
     * каждый элемент массива разбивается на
     * 2 части с учетом разделителя "="
     * и укладывается в HashMap, без "-"
     *
     */
    private void parse(String[] args) {

        for (String str:args) {
            String[] parameters = str.split("=");
            values.put(parameters[0].replace("-", ""), parameters[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }

}