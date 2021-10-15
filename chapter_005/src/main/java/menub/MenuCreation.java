package menub;

import java.util.Map;
import java.util.Set;

public interface MenuCreation {
    Set<String> createMenu(Map<String, Item> menu);
}
