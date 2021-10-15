package menua;

import menua.action.Action;
import java.util.List;

/**
 * Модель
 */
public class MenuItem {
    private String name;
    private List<MenuItem> childrenList;
    private MenuItem parent;
    private Action action;

    public MenuItem(String name, List<MenuItem> childrenList, Action action) {
        this.name = name;
        this.childrenList = childrenList;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuItem> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<MenuItem> childrenList) {
        this.childrenList = childrenList;
    }

    public MenuItem getParent() {
        return parent;
    }

    public void setParent(MenuItem parent) {
        this.parent = parent;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}