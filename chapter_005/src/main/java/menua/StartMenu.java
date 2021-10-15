package menua;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import menua.action.*;
import menua.show.*;


public class StartMenu {
    private static List<MenuItem> listMenu;

    public void init(Scanner scanner) {
        boolean run = true;
        while (run) {
            consoleMenu();
            System.out.println("Select: ");
            String select = scanner.nextLine();
            if (!select.equals("Exit")) {
                System.out.println("Пользователь выбрал меню: " + select);
            } else {
                run = false;
            }
        }
    }

    private void consoleMenu() {
        ShowMenu menu = new ShowTreeMenu();
        menu.showMenu(listMenu);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Action action1 = new SomeAction1();
        Action action2 = new SomeAction2();

        MenuItem menuLevel3Item1 = new MenuItem("Задача 1.1.1.", new ArrayList<>(), action1);
        MenuItem menuLevel3Item2 = new MenuItem("Задача 1.1.2.", new ArrayList<>(), action2);
        List<MenuItem> listLevel3 = List.of(menuLevel3Item1, menuLevel3Item2);
        MenuItem menuLevel2Item1 = new MenuItem("Задача 1.1.", listLevel3, action1);
        MenuItem menuLevel2Item2 = new MenuItem("Задача 1.2.", new ArrayList<>(), action2);
        List<MenuItem> listLevel2 = List.of(menuLevel2Item1, menuLevel2Item2);
        MenuItem menuLevel1Item1 = new MenuItem("Задача 1.", new ArrayList<>(), action1);
        MenuItem menuLevel1Item2 = new MenuItem("Exit", new ArrayList<>(), action2);
        List<MenuItem> listLevel1 = List.of(menuLevel1Item1, menuLevel1Item2);
        listMenu = listLevel1;
        new StartMenu().init(input);
    }
}