package salestax;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckOut {
    private Basket basket;

    public CheckOut(Basket basket) {
        this.basket = basket;
    }

    public List<String> generateReceipt() {
        ArrayList<String> receipt = new ArrayList<>();
        for (Map.Entry good: basket.getItems().entrySet()) {
            receipt.add(quantity(good) +" " + goodName(good));
        }
        receipt.add("Sales Taxes - "+basket.tax());
        receipt.add("Total - "+basket.priceIncludingTax());
        return receipt;

    }

    private String quantity(Map.Entry good) {
        return good.getValue().toString();
    }

    private String goodName(Map.Entry good) {
        return good.getKey().toString();
    }
}
