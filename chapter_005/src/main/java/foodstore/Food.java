package foodstore;

/**
 * Это модель еды
 *
 * name - название продукта
 * createDate - дата создания
 * expiryDate - дата истечения срока годности
 * price - цена
 * discount - скидка на продукт для Shop
 *
 * Добавляем параметр процент свежести
 * percentFresh, на основе которого можно
 * будет выбрать склад
 * Также пробуем расчитать его вовремя создания объекта
 *
 * now - предположим сегодня 20 число, для расчетов свежести
 * (везде int для упрощения расчетов)
 */
public class Food {

    private String name;
    private int createDate;
    private int expiryDate;
    private int price;
    private int discount;
    private int percentFresh;
    private int now = 20;

    public Food(String name, int createDate, int expiryDate, int price) {
        this.name = name;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.price = price;
        this.discount = 0;
        this.percentFresh = doPercentFresh();
    }

    /**
     * Из данных createDate, expiryDate
     * пробуем сразу расчитать процент свежести
     * percentFresh
     *
     * expiryDate - createDate = 100% (осталось 100% свежести)
     * expiryDate - now = ?
     *
     * шкала будет
     * 100 -> 50-> 10 ->0
     *
     * Тогда в Треш например уйдут продукты у которых свежесть < 0
     */
    private int doPercentFresh() {
        return (this.expiryDate - this.now) * 100 / (this.expiryDate - this.createDate);
    }

    public int getPercentFresh() {
        return percentFresh;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Food{"
                + "name='" + name + '\''
                +  ", createDate=" + createDate
                +  ", expiryDate=" + expiryDate
                +  ", price=" + price
                +  ", discount=" + discount
                +  ", percentFresh=" + percentFresh
                +  '}';
    }
}