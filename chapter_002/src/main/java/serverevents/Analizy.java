package serverevents;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    private static List<String> tmpList = new ArrayList<>();
    private static List<String> resultList = new ArrayList<>();

    /**
     *  Метод unavailable должен находить диапазоны,
     *  когда сервер не работал.
     */
    public static void main(String[] args) {
        unavailable();
    }

    private static void unavailable() {
        toList();
        String start = null;
        String end = null;
        String resultStr = null;
        for (String line : tmpList) {
            if ((line.contains("400") || line.contains("500")) && start == null) {
                start = line.substring(4, line.length());
            }
            if ((line.contains("200") || line.contains("300")) && (start != null && end == null)) {
                end = line.substring(4, line.length());
                resultStr = start + ";" + end;
                start = null;
                end = null;
                resultList.add(resultStr);
            }
        }
        toFile();
    }

    private static void toList() {
        try (BufferedReader in = new BufferedReader(
                new FileReader("./chapter_002/src/main/java/serverevents/source.txt"))) {
            in.lines().forEach(tmpList::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void toFile() {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("./chapter_002/src/main/java/serverevents/target.txt")
                ))) {
            resultList.forEach(value -> out.write(value + System.lineSeparator()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}