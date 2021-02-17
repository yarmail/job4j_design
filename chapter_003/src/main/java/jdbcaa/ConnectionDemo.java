package jdbcaa;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*
        После добавления зависимости на драйвер, нам необходимо
        его зарегистрировать в системе. Чтобы это сделать необходимо
        прописать строку.
         */
        Class.forName("org.postgresql.Driver");

        /*
        Теперь можно подключаться к БД.
        Для подключения нам нужны url, логин (имя пользователя)
        и пароль. Чтобы получить подключения нужно
        воспользоваться классом DriverManager, передав
        ему эти аргументы.

        String url = "jdbc:postgresql://localhost:5432/idea_db";
        String login = "postgres";
        String password = "password";
        */

        /*
         * Задание
         * Доработайте код программы, чтобы чтения url, имени пользователя
         * и пароля шло из файла jdbc.properties
         */

        Properties prop = new Properties();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("jdbc.properties")) {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = prop.getProperty("url");
        String login = prop.getProperty("login");
        String password = prop.getProperty("password");


        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }

        /* Правильный результат получен
        postgres
        jdbc:postgresql://localhost:5432/idea_db
         */
    }
}