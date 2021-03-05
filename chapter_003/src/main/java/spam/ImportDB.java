package spam;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {
    private Properties cfg;
    private BufferedReader dump;

    public ImportDB(Properties cfg, BufferedReader dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        dump.lines().forEach(line -> {
            String[] elements = line.split(";");
            /*проверяем в консоли что получилось*/
            System.out.println(elements[0]);
            System.out.println(elements[1]);
            users.add(new User(elements[0], elements[1]));
        });
        return  users;
    }
    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            /*
            Если таблица не создана заранее - её можно создать
            Statement st = cnt.createStatement();
            st.executeUpdate("CREATE TABLE IF NOT EXISTS users (id serial primary key, name varchar(255), email varchar(255))");
            st.close();
             */
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement("INSERT INTO users (name, email) VALUES ((?), (?))")) {
                    ps.setString(1, user.name);
                    ps.setString(1, user.email);
                    ps.execute();
                }
            }
        }

    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    /**
     * Перед запуском main следует убедиться что у вас уже есть база spam.
     */
    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (InputStream is = ImportDB.class.getClassLoader().getResourceAsStream("spam.properties")) {
            cfg.load(is);
        }
        InputStreamReader isr = new InputStreamReader(ImportDB.class.getClassLoader().getResourceAsStream("spam.txt"));
        BufferedReader dump = new BufferedReader(isr);

        ImportDB db = new ImportDB(cfg, dump);
    }
}