package salestax;

import java.util.HashMap;

import static java.util.Map.Entry;


public class Basket {

    private final HashMap<Good,Integer> goods = new HashMap<>();

    public void addItem(Good item, int quantity) {
        goods.put(item,quantity);
    }

    public Money tax() {
        Money totalTax=Money.ZERO;
        for (Entry good: goods.entrySet()) {
            Money taxPerUnit = good(good).tax();
            Money taxForAllUnits = taxPerUnit.timesOf(quantity(good));
            totalTax = totalTax.add(taxForAllUnits);
        }
        return totalTax;
    }

    public Money priceIncludingTax() {
        Money totalPrice=Money.ZERO;
        for (Entry good: goods.entrySet()) {
            Money pricePerUnit = good(good).totalPrice();
            Money priceForAllUnits = pricePerUnit.timesOf(quantity(good));
            totalPrice = totalPrice.add(priceForAllUnits);
        }
        return totalPrice;
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
