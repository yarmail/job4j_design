package filedir;

import java.io.File;

public class Dir {

    public static void main(String[] args) {
        // в данном случае file  это директория
        File file = new File("c:\\projects");
        // Существует?
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        // Директория?
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        // абсолютный размер
        System.out.println(String.format("size : %s", file.getTotalSpace()));
        for (File subfile : file.listFiles()) {
            // абсолютный путь
            //System.out.println(subfile.getAbsoluteFile());
            // По заданию возвращаем имя и размер
            System.out.println(subfile.getName() + " " + subfile.length());
        }
    }
}