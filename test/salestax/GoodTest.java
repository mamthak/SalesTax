package salestax;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoodTest {

    @Test
    public void shouldCreateAGoodWithTheGivenProperties(){
        Good good = new Good("Book", new Money(12.49),false,false);
        assertEquals(good.getClass(), Good.class);

    }
    @Test
    public void shouldVerifyIfSalesTaxAndImportSalesTaxAreAppliedForANonExemptedImportedGood(){
        Good good = new Good("Book", new Money(10.00), true,false);
        assertEquals(new Money(1.5),good.tax());
    }

    @Test
    public void shouldVerifyIfOnlyImportSalesTaxIsAppliedForAnExemptedImportedGood(){
        Good good = new Good("Book", new Money(10.00), true,true);
        assertEquals(new Money(0.5),good.tax());
    }

    @Test
    public void shouldVerifyIfOnlySalesTaxIsAppliedForANonExemptedNonImportedGood(){
        Good good = new Good("Book", new Money(10.00), false,false);
        assertEquals(new Money(1.0),good.tax());
    }

    @Test
    public void shouldVerifyIfNoTaxesAreAppliedForAnExemptedNonImportedGood(){
        Good good = new Good("Book", new Money(10.00), false,true);
        assertEquals(new Money(0.0),good.tax());
    }

    @Test
    public void shouldVerifyIfTotalPriceIsCalculatedInculdingTaxesForAGood(){
        Good good = new Good("Book", new Money(10.00), true,false);
        assertEquals(new Money(11.5),good.totalPrice());
    }

    @Test
    public void shouldVerifyIfToStringMethodReturnsTheGoodDescription(){
        Good good = new Good("Book", new Money(10.01), true,false);
        assertEquals("Book at 10.01",good.toString());
    }

}