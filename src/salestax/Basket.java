package salestax;

import java.util.HashMap;

import static java.util.Map.Entry;


public class Basket {

    private final HashMap<Good,Integer> goods = new HashMap<>();

    public void addItem(Good item, int quantity) {
        goods.put(item,quantity);
    }

    public Money tax() {
        Money tax=Money.ZERO;
        for (Entry good: goods.entrySet()) {
            tax = tax.add(good(good).Tax().timesOf(quantity(good)));
        }
        return tax;
    }

    public Money priceIncludingTax() {
        Money price=Money.ZERO;
        for (Entry good: goods.entrySet()) {
            price = price.add(good(good).TotalPrice().timesOf(quantity(good)));
        }
        return price;
    }

    public HashMap<Good,Integer> getItems() {
        return goods;
    }

    private int quantity(Entry good) {
        return (Integer) good.getValue();
    }

    private Good good(Entry good) {
        return (Good) good.getKey();
    }

}
