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

    public void setName(String name) {
        this.name = name;
    }

    public TreeSet<String> getEmails() {
        return emails;
    }

    public void setEmails(TreeSet<String> emails) {
        this.emails = emails;
    }
}
