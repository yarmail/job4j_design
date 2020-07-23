package map;

import java.util.Objects;

/**
 * В этой модели переопределим только hashcode
 * и посмотрим результаты в тесте
 */
public class UserTwo {
    private String name;

    public UserTwo(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
