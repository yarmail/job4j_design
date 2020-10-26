package consolechat;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class ConsoleChat {

    private final String pathSrc;
    private final String pathDest;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    // для предварительной записи диалога
    private List<String> dialogList = new ArrayList<>(0);

    /**
     * @param pathSrc - это файл с ответами бота
     * @param pathDest - это файл с записью диалога обоих сторон
     */
    public ConsoleChat(String pathSrc, String pathDest) {
        this.pathSrc = pathSrc;
        this.pathDest = pathDest;
    }

    /**
     * Еще возможный вариант вывода:
     * PrintStream console = System.out;
     * System.setOut(console);
     */
    public void run() throws IOException {
        Scanner input = new Scanner(System.in);
        String userAnswer = "";
        List<String> botAnswerList = Files.readAllLines(Paths.get(pathSrc));
        int sizeAnswers = botAnswerList.size();
        String botAnswer = "";
        System.out.println("Здравствуйте, давайте поговорим");
        System.out.println("В беседе вы можете использовать команды: закончить, стоп, продолжить");
        while (!userAnswer.equals(OUT)) {
            userAnswer = input.nextLine();
            dialogList.add(userAnswer);
            botAnswer = botAnswerList.get(new Random().nextInt(sizeAnswers));
            System.out.println(botAnswer);
            dialogList.add(botAnswer);
            if (userAnswer.equals(STOP)) {
                while (!userAnswer.equals(CONTINUE)) {
                    userAnswer = input.nextLine();
                    dialogList.add(userAnswer);
                }
            }
        }
        if (userAnswer.equals(OUT)) {
            dialogList.add(userAnswer);
            writeDataInFile(pathDest, dialogList);
            // для проверки
            System.out.println("Проверка содержимого файла назначения");
            List<String> check = Files.readAllLines(Paths.get(pathDest));
            check.forEach(System.out::println);
        }
    }

    /**
     * tempDir - Создаем временную директорию для наших файлов
     * Получилось что-то вроде
     * C:\Users\01-2017\AppData\Local\Temp\2388449321904651433
     * Папку нужно будет убирать
     * Во время разработки не убираем, чтобы посмотреть как получается
     *
     * Также создаем
     * один файл с ответами бота - source.txt
     * и один пустой файл для записи диалога - dest.txt
     *
     */
    public static void main(String[] args) throws IOException {
        Path tempDir = Files.createTempDirectory(null).toAbsolutePath();
        String pathSrc = tempDir.resolve("source.txt").toString();
        String pathDest = tempDir.resolve("dest.txt").toString();
        List<String> strings = List.of(
                "String 1",
                "String 2",
                "String 3",
                "String 4",
                "String 5"
        );
        writeDataInFile(pathSrc, strings);
        ConsoleChat cc = new ConsoleChat(pathSrc, pathDest);
        cc.run();
        // удаляем все созданные временные файлы и папки
        boolean deleteAll = Files.deleteIfExists(Paths.get(pathSrc));
        deleteAll = Files.deleteIfExists(Paths.get(pathDest));
        deleteAll = Files.deleteIfExists(tempDir);
    }

    /**
     * Метод поможет в 2- случаях,
     * 1) создать файл с ответами
     * 2) записать весь диалог в виде List в файл dest.txt
     *
     * по пока непонятной причине FileWriter и bufferedWriter.write
     * потребовали обернуть их в try catch c IOException
     * Пока не пойму как упростить
     */
    public static void writeDataInFile(String path, List<String> strings) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(path, Charset.forName("UTF-8"), true))) {
            strings.forEach(value -> {
                try {
                    bufferedWriter.write(value + System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}