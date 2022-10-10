package scannercsv;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

/**
 * (есть тесты)
 */
public class CSVReader {

    public static void handle(ArgsName argsName) {
        List<List<String>> lines = read(argsName);
        List<Integer> ind =  index(lines, argsName.get("filter").split(","));
        if ("stdout".equals(argsName.get("out"))) {
            console(lines, ind, argsName);
        } else {
            write(lines, ind, argsName);
        }
    }

    public static List<Integer> index(List<List<String>> lines, String[] filter) {
        List<Integer> in = new ArrayList<>();
        for (String f : filter) {
            in.add(lines.get(0).indexOf(f));
        }
        return in;
    }

    public static List<List<String>> read(ArgsName argsName) {
        List<List<String>> lines = new ArrayList<>();
        try (var scanner = new Scanner(Path.of(argsName.get("path"))).useDelimiter(argsName.get("delimiter"))) {
            while (scanner.hasNext()) {
                lines.add(Arrays.asList(scanner.nextLine().split(argsName.get("delimiter"))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void console(List<List<String>> lines, List<Integer> in, ArgsName argsName) {
        for (List<String> l :lines) {
            for (int i = 0; i < in.size(); i++) {
                if (i < in.size() - 1) {
                    System.out.print(l.get(in.get(i)) + ";");
                } else {
                    System.out.print(l.get(in.get(i)));
                }
            }
            System.out.println();
        }
    }

    public static void write(List<List<String>> lines, List<Integer> in, ArgsName argsName) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(argsName.get("out"), true))) {
            for (List<String> l :lines) {
                for (int i = 0; i < in.size(); i++) {
                    if (i < in.size() - 1) {
                        pw.print(l.get(in.get(i)) + ";");
                    } else {
                        pw.print(l.get(in.get(i)));
                    }
                }
                pw.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void check(ArgsName argsName) {
        if (!argsName.get("path").endsWith(".csv")) {
            throw new IllegalArgumentException("No read File!");
        }
        if (!";".equals(argsName.get("delimiter"))) {
            throw new IllegalArgumentException("Does not contain the sing \";\"");
        }
        if (!("stdout".equals(argsName.get("out")) || argsName.get("out").endsWith(".csv"))) {
            throw new IllegalArgumentException("No write File");
        }
        if (!(argsName.get("filter").contains("name")
                || argsName.get("filter").contains("age")
                || argsName.get("filter").contains("last_name")
                || argsName.get("filter").contains("education"))) {
            throw new IllegalArgumentException("No filter");
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            throw new IllegalArgumentException("No arguments!");
        }
        ArgsName argsName = ArgsName.of(args);
        check(argsName);
        handle(argsName);
    }
}
