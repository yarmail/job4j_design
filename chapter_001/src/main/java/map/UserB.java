package map;

import java.util.Objects;

/**
 * В этой модели переопределим только hashcode
 * и посмотрим результаты в тесте
 */
public class UserB {
    private String name;

    public UserB(String name) {
        this.name = name;
    }
/*  Definition of 'hashCode()' without corresponding definition of 'equals()'.
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

 */
}
