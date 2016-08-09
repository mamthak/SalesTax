package salestax;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BasketTest {

    @Test
    public void shouldBeAbleToCalculateTheTotalSalesTaxForTheGoodsInTheBasket(){
        Basket basket = new Basket();
        Good good = new Good("Chocolate", new Money(12.00), false, false);
        basket.addItem(good,1);
        Good anotherGood= new Good("Chocolate", new Money(10.00), false, false);
        basket.addItem(anotherGood, 2);
        assertEquals(new Money(3.2),basket.tax());

    }
    @Test
    public void shouldBeAbleToCalculateTheTotalPriceForTheGoodsInTheBasket(){
        Basket basket = new Basket();
        Good good = new Good("Chocolate", new Money(12.00), false, false);
        basket.addItem(good, 1);
        Good anotherGood= new Good("Chocolate", new Money(10.00), false, false);
        basket.addItem(anotherGood, 1);
        assertEquals(new Money(24.2),basket.priceIncludingTax());

    }

    @Test
    public void shouldBeAbleToVerifyIfTaxandTotalPriceAreZeroIfTheBasketIsEmpty(){
        Basket basket = new Basket();
        assertEquals(Money.ZERO,basket.priceIncludingTax());
        assertEquals(Money.ZERO,basket.tax());
    }

    @Test
    public void shouldGetTheListofItemsFromTheBasket(){
        Basket basket = new Basket();
        Good good = new Good("Chocolate", new Money(12.00), false, false);
        basket.addItem(good, 1);
        assertEquals(basket.getItems().size(),1);
        assertTrue(basket.getItems().containsKey(good));
        assertTrue(basket.getItems().containsValue(1));
    }
}
