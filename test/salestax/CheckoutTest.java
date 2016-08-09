package salestax;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckOutTest {

    @Test
    public void shouldBeAbleToGenerateReciptForASingleGoodInTheBasket(){
        Basket basket = mock(Basket.class);
        CheckOut checkOut = new CheckOut(basket);
        HashMap<Good, Integer> goodsWithQuantity = new HashMap<>();
        goodsWithQuantity.put(new Good("Chocolate",new Money(10.0),false,false),1);
        when(basket.getItems()).thenReturn(goodsWithQuantity);
        when(basket.tax()).thenReturn(new Money(0.05));
        when(basket.priceIncludingTax()).thenReturn(new Money(10.05));

        List<String> receipt = checkOut.generateReceipt();

        assertEquals("1 Chocolate - 10.0", receipt.get(0));
        assertEquals("Sales Taxes - 0.05", receipt.get(1));
        assertEquals("Total - 10.05", receipt.get(2));


    }

    @Test
    public void shouldBeAbleToGenerateReceiptForMultipleGoodsInTheBasket(){
        Basket basket = mock(Basket.class);
        CheckOut checkOut = new CheckOut(basket);
        HashMap<Good, Integer> goodsWithQuantity = new HashMap<>();
        goodsWithQuantity.put(new Good("Chocolate",new Money(10.0),false,false),1);
        goodsWithQuantity.put(new Good("Imported Pink Color Watch",new Money(100.0),false,false),1);

        when(basket.getItems()).thenReturn(goodsWithQuantity);
        when(basket.tax()).thenReturn(new Money(1.05));
        when(basket.priceIncludingTax()).thenReturn(new Money(111.05));

        List<String> receipt = checkOut.generateReceipt();

        assertEquals("1 Chocolate - 10.0", receipt.get(0));
        assertEquals("1 Imported Pink Color Watch - 100.0", receipt.get(1));
        assertEquals("Sales Taxes - 1.05", receipt.get(2));
        assertEquals("Total - 111.05", receipt.get(3));


    }
}
