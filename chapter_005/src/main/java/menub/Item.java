package menub;

import java.util.List;

public class Item {
    private String name;
    private List<Item> items;
    private Action action;

    public Item(String name, List<Item> items) {
        this.name = name;
        this.items = items;
        this.action = action;
    }

    public Item(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    public Action getAction() {
        return action;
    }
}