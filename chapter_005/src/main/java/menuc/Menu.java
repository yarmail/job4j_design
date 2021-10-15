package menuc;

import java.util.Scanner;
import java.util.TreeMap;

public class Menu {
    private static final String EXIT = "выход";
    private TreeMap<Item, ActionOne> tree;

    public static void main(String[] args) {
        Menu m = new Menu();
        m.console();
    }

    public void console() {
        Scanner scanner = new Scanner(System.in);
        callMenu();
        String answer = scanner.next();
        while (!answer.equals(EXIT)) {
            if (tree.containsKey(new Item(answer))) {
                System.out.println(tree.get(new Item(answer)).doSomethind());
            } else {
                System.out.println("Введен неправильный номер задачи");
            }
            System.out.println();
            callMenu();
            answer = scanner.next();
        }
    }

    private void callMenu() {
        if (tree == null) {
            tree = new TreeMap<>();
            setTree();
        }
        System.out.println("Меню:");
        for (var a : tree.entrySet()) {
            System.out.println("Задача " + a.getKey().getLevel());
        }
        System.out.print("Введите номер задачи: ");
    }

    private void setTree() {
        tree.put(new Item("1"), new ActionOne("1"));
        tree.put(new Item("1.1"), new ActionOne("1.1"));
        tree.put(new Item("1.1.1"), new ActionOne("1.1.1"));
        tree.put(new Item("1.1.2"), new ActionOne("1.1.2"));
        tree.put(new Item("1.2"), new ActionOne("1.2"));
        tree.put(new Item("2"), new ActionOne("2"));
        tree.put(new Item("2.1"), new ActionOne("2.1"));
        tree.put(new Item("2.2"), new ActionOne("2.2"));
    }
}