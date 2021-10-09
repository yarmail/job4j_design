package lspphone;

public class SomeOperatorSubscriber extends Subscriber {
    public SomeOperatorSubscriber(PhoneNumber phoneNumber) {
        super(phoneNumber);
    }

    /**
     *  some specific logic;
     *  Забыли сделать проверку. Возможно не валидное состояние
     */
    @Override
    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}