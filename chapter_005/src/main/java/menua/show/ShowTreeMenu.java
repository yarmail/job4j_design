package menua.show;

import java.util.List;
import menua.MenuItem;


public class ShowTreeMenu implements ShowMenu {
    @Override
    public void showMenu(List<MenuItem> listMenu) {
        for (MenuItem menuItem : listMenu) {
            String result = menuItem.getName();
            System.out.println(result);
            while (!menuItem.getChildrenList().isEmpty()) {
                showMenu(listMenu);
            }
        }
    }
}