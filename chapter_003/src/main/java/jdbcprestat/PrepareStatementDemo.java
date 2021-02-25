package jdbcprestat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrepareStatementDemo {
    private Connection connection;

    public PrepareStatementDemo() throws Exception {
        initConnection();
    }

    public void initConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/idea_db";
        String login = "postgres";
        String password = "password";
        connection = DriverManager.getConnection(url, login, password);
    }

    public void insert(City city) {
        try (PreparedStatement statement = connection.prepareStatement(
                // места, куда будут подставлятся аргуметы обозначаются ?
                "insert into cities(name, population) values (?, ?)")) {
            // для подстановки аргументов используются методы вида "setТип (позиция, аргумент)
            statement.setString(1, city.getName());
            // позиция аргумента считается как его порядковый номер, т.е. с 1
            statement.setInt(2, city.getPopulation());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /* Получение вставленного элемента с использованием JDBC
    Для того чтобы получить id нужно при создании PrepareStatement
    вторым аргументом передать Statement.RETURNING_GENERATED_KEYS.
    После этого как обычно выполнить запрос. Наконец, чтобы получить
    ключ нужно вызвать метод getGeneratedKeys(). Давайте перепишем метод insert,
    так чтобы он возвращал переданный city, только уже с проставленным id из БД.
     */
    public City insert2(City city) {
        try (PreparedStatement statement = connection.prepareStatement(
                "insert into cities(name, populations) values (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    city.setId(generatedKeys.getInt(1));
                }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // возвращаем переданный city, только уже с проставленным id из БД.
        return city;
    }


    // метод update() возвращает boolean, это нужно для того,
    // чтобы узнать произошло обновление или нет
    public boolean update(City city) {
        boolean result = false;
        try (PreparedStatement statement = connection.prepareStatement(
                "update cities set name = ?, population = ? where id = ?")) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.setInt(3, city.getId());
            // чтобы узнать произошло само обновление мы используем
            // метод executeUpdate(), если это метод возвращает 0,
            // то значит оно не произошло, поэтому мы проверяем, что результат больше 0.
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // удаление аналогично обновлению
    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement statement = connection.prepareStatement(
                "delete from cities where id = ?")) {
            statement.setInt(1, id);
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(
                "select * from sities")) {
            // ResultSet мы использовали вместе с try-with-resources
            try (ResultSet resultSet = statement.executeQuery()) {
                //чтобы сдвинуть курсор используется метод next(),
                // если он возвращает true, то сдвиг произошел и мы можем получить данные.
                while (resultSet.next()) {
                    cities.add(new City(
                            //чтобы получить доступ к элементу записи
                            // используем метод «getТип(имя_столбца)
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("population")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    /**
     * попробуем хотя бы частично проверить как это работает
     * запускаем main и через консоль проверяем что появилось в базе
     * select * from cities;
     * (все работает)
     */
    public static void main(String[] args) throws Exception {
        PrepareStatementDemo newDemo = new PrepareStatementDemo();
        City moscow = new City(1, "Moscow", 20);
        newDemo.insert(moscow);
    }
}