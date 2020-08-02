package map;

import java.util.Objects;

/**
 * В этом примере переопределяем equals и hashcode
 */
public class UserD {
    private String name;

    public UserD(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserD)) return false;
        UserD userD = (UserD) o;
        return Objects.equals(name, userD.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
