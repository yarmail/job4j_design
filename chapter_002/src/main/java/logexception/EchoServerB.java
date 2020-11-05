package logexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.stream.Stream;

/**
 * Задание
 * Уберите из сигнатуры метода main исключение.
 * Обработайте его через catch c выводом в логгер.
 */
public class EchoServerB {

    private static final Logger LOG = LoggerFactory.getLogger(EchoServerB.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    // смотрим, что пришло
                    System.out.println("Поступило от клиента:"  + str);
                    // фильтруем из ответа клиента нужный кусок "/?msg=MSG"
                    if (!str.isEmpty()) {
                        str = Stream.of(str.split(" "))
                                .filter(s -> s.contains("msg"))
                                .findFirst()
                                .orElse("");
                    }
                    // проверяем что получилось
                    System.out.println("Отфильтровано фильтром для msg: " + str);
                    if (!str.isEmpty()) {
                        String[] arrStr = str.split("=");
                        str = arrStr[1];
                        out.write("HTTP/1.1 200 OK\r\n\r\n".concat(str).getBytes());
                        if (str.equals("Exit")) {
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            LOG.error("Здесь мы должны написать, что произошла какая-то ошибка IO или что-то ещё", e);
        }
    }
}