package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.stream.Stream;


/**
 * Server response to various questions
 * Ответ сервера на разные вопросы
 * 1. Бот [#293826]
 *
 * Клиент отправляет запросы, сервер должен ему отвечать.
 * Протокол HTTP - это удобная обёртка над протоколом TCP/IP.
 *
 * Будем использовать браузер
 * Запустите браузер и откройте
 * ссылку http://localhost:9000/?msg=Hello.
 *
 * Давайте добавим ответ клиенту.
 * out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
 * out.write("Hello, dear friend.".getBytes());
 *
 * -----------
 *
 * Задание:
 * msg=Hello > Hello.
 *
 * msg=Exit > Завершить работу сервера.
 *
 * msg=Any > Any.
 *
 * Пример запроса для браузера:
 * http://localhost:9000/?msg=MSG
 *
 * Примечание - от хрома последовательно поступают 2 запроса вместо одного
 * GET /?msg=msg HTTP/1.1
 * GET /favicon.ico HTTP/1.1
 */
public class EchoServerB {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean work = true;
            while (work) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    // смотрим, что пришло
                    System.out.println("Поступило" + System.lineSeparator() + str);
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
                        if (str.equals("Exit")) {
                            work = false;
                            out.write("HTTP/1.1 200 OK\r\n".getBytes());
                            out.write("Exit".getBytes());
                        } else {
                            out.write("HTTP/1.1 200 OK\r\n".getBytes());
                            out.write(str.getBytes());
                        }
                    }
                }
            }
        }
    }
}