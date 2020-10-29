package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


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
 *
 *
 *
 *
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
                    // сообщение в строку попадает в виде "GET /?msg=Hello HTTP/1.1"
                    String str = in.readLine();
                    System.out.println(str);
                    if (!str.isEmpty()) {
                        String[] arrSrt = str.split("=");
                        str = arrSrt[1];
                        arrSrt = str.split(" ");
                        str = arrSrt[0];
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