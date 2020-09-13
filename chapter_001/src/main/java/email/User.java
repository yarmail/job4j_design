package email;

import java.util.TreeSet;

public class User {
    private String name;
    private TreeSet<String> emails;

    public User(String name, TreeSet<String> emails) {
        this.name = name;
        this.emails = emails;
    }

    public String getName() {
        return name;
    }

    public TreeSet<String> getEmails() {
        return emails;
    }
}
