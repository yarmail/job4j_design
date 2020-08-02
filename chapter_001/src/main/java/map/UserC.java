package map;

import java.util.Objects;

public class UserC {
    private String name;

    public UserC(String name) {
        this.name = name;
    }

/* К сожалению check style не позволяет переопределение
только equals поэтому блокирую здесь и в тесте userCTest()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserC)) return false;
        UserC userC = (UserC) o;
        return Objects.equals(name, userC.name);
    }
*/
}
