package jdbcstat;

import java.sql.*;

public class StatementDemo {
    /**
     * Выносим создание подключения в отдельный метод
     * @return
     * @throws Exception
     */
    private static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/idea_db";
        String login = "postgres";
        String password = "password";
        return DriverManager.getConnection(url, login, password);
    }

    /**
     * Чтобы проверить, что таблица создалась давайте выведем ее схему,
     * а именно ее столбцы и их типы. Для этого напишем отдельный метод
     * @param connection
     * @param tableName
     * @return
     * @throws Exception
     */
    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    /**
     * Создадим запрос на создание таблицы
     * Пока мы просто создали объект для запроса.
     * Для его выполнения существуют 3 метода: execute(), executeUpdate(),
     * executeQuery(). Последние два мы пока опустим и поговорим
     * про них позже. В общем случае можно использовать просто
     * метод execute().
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "create table if not exists demo_table(%s, %s);",
                        "id serial primary key",
                        "name varchar(255)"
                );
                statement.execute(sql);
                System.out.println(getTableScheme(connection, "demo_table"));
            }
        }
    }
    /*
    Результат:
    column          type
    id              serial
    name            varchar
     */
}
