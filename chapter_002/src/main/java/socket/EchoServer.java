package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Сначала нам нужно создать сервер.
 *  try (ServerSocket server = new ServerSocket(9000)) {
 *  ...
 *
 * ServerSocket создает сервер. Чтобы клиент мог узнать,
 * где находится сервер ему нужен адрес и порт.
 * По аналогии с людьми мы обращаемся по имени, чтобы начать разговор.
 *
 * 9000 - это порт. По умолчанию адрес будет localhost.
 * Socket socket = server.accept();
 * ...
 *
 * Когда клиент обратился к серверу программа получает
 * входной поток и может отправить данные в выходной поток.
 *  try (OutputStream out = socket.getOutputStream();
 *  ...
 * В программе читается весь входной поток.
 * String str;
 * ...
 *
 * В ответ мы записываем строчку.
 * out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
 *
 * Зачем тут нужен вечный цикл?
 * метод ассеpt принимает один запрос от клиента,
 * чтобы отправить второй, программа должна
 * снова получить объект socket.
 *
 */
public class EchoServer {
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
                    while (!str.isEmpty()) {
                        // задание по теме: Что такое Socket
                        if (str.contains("Bye")) {
                            work = false;
                            break;
                        }
                    }
                    if (work) {
                        out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                    } else {
                        // Как я понимаю вывод тоже должен быть из 3-х частей
                        out.write("HTTP/1.1 522 Bye bye\r\n\\".getBytes());
                    }


                }
            }
        }
    }
}