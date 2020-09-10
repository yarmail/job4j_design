package email;

import java.util.ArrayList;
import java.util.TreeSet;

public class Process {

    private ArrayList<User> dest = new ArrayList<>(0);

    public ArrayList<User> process(ArrayList<User> source) {
        if (source != null) {
            dest = process2(source);
        }
        return dest;
    }

    private ArrayList<User> process2(ArrayList<User> source) {
            for (int i = 0; i < source.size(); i++) {
                    User userSource = source.get(i);
                    TreeSet<String> emailsSource = userSource.getEmails();
                    boolean originalEmailsSource = true;
                    for (String email:emailsSource) {
                        int findEmail = findEmail(email);
                        if (findEmail != -1) {
                            User userDest = dest.get(findEmail);
                            TreeSet<String> emailsDest = userDest.getEmails();
                            emailsDest.addAll(emailsSource);
                            userDest.setEmails(emailsDest);
                            originalEmailsSource = false;
                            break;
                        }
                    }
                    if (originalEmailsSource) {
                        dest.add(userSource);
                    }
            }
            dest.trimToSize();
        return dest;
    }

    /**
     * find email in Dest
     * @return index of User
     */
    private int findEmail(String email) {
        int result = -1;
        for (int i = 0; i < dest.size(); i++) {
            User userDest = dest.get(i);
            TreeSet emailsDest = userDest.getEmails();
            if (emailsDest.contains(email)) {
                result = i;
                break;
            }
        }
    return result;
    }
}
