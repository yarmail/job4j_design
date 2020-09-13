package email;

import java.util.*;


public class Process {

    public Map<String, TreeSet<String>> process(ArrayList<User> source) {
        Map<String, String> tempMap = new HashMap<>();
        for (int i = 0; i < source.size(); i++) {
            User user = source.get(i);
            String name = user.getName();
            TreeSet<String> emails = user.getEmails();
            for (String email : emails) {
                tempMap.put(email, name);
            }
        }
        Map<String, TreeSet<String>> resultMap = new HashMap<>();
        Iterator<String> itr = tempMap.keySet().iterator();
        while (itr.hasNext()) {
            String email = itr.next();
            String name = tempMap.get(email);
            if (!resultMap.containsKey(name)) {
                TreeSet<String> emails = new TreeSet<>();
                emails.add(email);
                resultMap.put(name, emails);
            }
            if (resultMap.containsKey(name)) {
                TreeSet<String> emails = resultMap.get(name);
                emails.add(email);
                resultMap.put(name, emails);
            }
        }
        return resultMap;
    }
}
