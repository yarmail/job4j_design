package menuc;

public class ActionOne implements Action {
    private final String number;

    public ActionOne(String number) {
        this.number = number;
    }

    @Override
    public String doSomethind() {
        return "Задача " + number + " что-то сделала";
    }
}
