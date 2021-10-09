package lspphone;

/**
 * Есть абонент. (этот класс)
 * От него наследуется абонент какого-то оператора.
 * Но при переопределении сеттера, забыли сделать проверку.
 * Поэтому код в маине запускается успешно.
 * Ошибка остается. Нарушено состояние объекта потомка,
 * потому что в нем не соблюдено условие предка.
 */
class Subscriber {
    protected PhoneNumber phoneNumber;

    public Subscriber(PhoneNumber phoneNumber) {
        validate(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    protected void validate(PhoneNumber phoneNumber) {
        if (phoneNumber.getCountryCode() < 1 || phoneNumber.getCountryCode() > 999) {
            throw new IllegalArgumentException("Invalid country code!");
        }
        if (phoneNumber.getCityCode() < 1 || phoneNumber.getCityCode() > 999) {
            throw new IllegalArgumentException("Invalid city code!");
        }
        if (phoneNumber.getNumber() < 1 || phoneNumber.getNumber() > 999_999_999) {
            throw new IllegalArgumentException("Invalid number!");
        }
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        validate(phoneNumber);
        this.phoneNumber = phoneNumber;
    }
}