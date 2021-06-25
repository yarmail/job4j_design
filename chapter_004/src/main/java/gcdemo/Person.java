package gcdemo;


/**
 * В классе Object есть метод finalize().
 * Этот метод вызывается перед тем как объект уничтожется,
 * однако этот метод является устаревшим и не
 * рекомендуется его использовать.
 * Тем не менее мы можем применить
 * для демонстрации работы сборки мусора.
 *
 *
 */
public class Person {

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", age, name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
