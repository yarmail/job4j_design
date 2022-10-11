package scannercsv;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 7. Scanner [#504791 #350417]
 * В качестве входных данных задается путь к файлу path,
 * разделитель delimiter, например: ; ,
 * приемник данных out: stdout или путь к файлу,
 * фильтр по столбцам filter, например: name,age
 * (есть тесты)
 */
public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        String output = argsName.get("out");
        try (Scanner scanner = new Scanner(new FileInputStream(argsName.get("path")));
             PrintStream out = "stdout".equals(output) ? new PrintStream(System.out)
                     : new PrintStream(new FileOutputStream(output))) {
            scanner.useDelimiter(System.lineSeparator());
            List<String> filters = Arrays.stream(argsName.get("filter").split(","))
                    .collect(Collectors.toList());
            List<String> columns = Arrays.stream(scanner.next().split(argsName.get("delimiter")))
                    .collect(Collectors.toList());
            List<Integer> indexes = filters.stream()
                    .mapToInt(columns::indexOf)
                    .filter(index -> index != -1)
                    .boxed()
                    .collect(Collectors.toList());

            String filteredColumns = filterLine(columns, indexes, argsName.get("delimiter"));
            out.println(filteredColumns);
            while (scanner.hasNext()) {
                List<String> line = Arrays.asList(scanner.next().split(argsName.get("delimiter")));
                String filteredLine = filterLine(line, indexes, argsName.get("delimiter"));
                out.println(filteredLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String filterLine(List<String> line, List<Integer> indexes, String delimiter) {
        return indexes.stream()
                .map(line::get)
                .collect(Collectors.joining(delimiter));
    }



    private static boolean checkArgs(ArgsName argsName) {
        if (!Paths.get(argsName.get("path")).toFile().exists()) {
            throw new IllegalArgumentException("The file does not exist");
        }
        if (argsName.get("out").isEmpty()) {
            throw new IllegalArgumentException("Out doesn't exist");
        }
        if (argsName.get("filter").isBlank()) {
            throw new IllegalArgumentException("Filter doesn't exist");
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            throw new IllegalArgumentException("args.length != 4");
        }
        if (checkArgs(ArgsName.of(args))) {
            handle(ArgsName.of(args));
        }

    }
}