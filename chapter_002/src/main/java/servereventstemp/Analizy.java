package servereventstemp;

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

    public static void unavailable(String source, String target) {
        toList(source);
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
        toFile(target);
    }

    private static void toList(String source) {
        try (BufferedReader in = new BufferedReader(
                new FileReader(source))) {
            in.lines().forEach(tmpList::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void toFile(String target) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)
                ))) {
            resultList.forEach(value -> out.write(value + System.lineSeparator()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}