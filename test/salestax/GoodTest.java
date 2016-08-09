package salestax;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoodTest {

    @Test
    public void ShouldCreateAGoodWithTheGivenProperties(){
        Good good = new Good("Book", new Money(12.49),false,false);
        assertEquals(good.getClass(), Good.class);

    }
    @Test
    public void ShouldVerifyIfSalesTaxAndImportSalesTaxAreAppliedForANonExemptedImportedGood(){
        Good good = new Good("Book", new Money(10.00), true,false);
        assertEquals(new Money(1.5),good.Tax());
    }

    @Test
    public void ShouldVerifyIfOnlyImportSalesTaxIsAppliedForAnExemptedImportedGood(){
        Good good = new Good("Book", new Money(10.00), true,true);
        assertEquals(new Money(0.5),good.Tax());
    }

    @Test
    public void ShouldVerifyIfOnlySalesTaxIsAppliedForANonExemptedNonImportedGood(){
        Good good = new Good("Book", new Money(10.00), false,false);
        assertEquals(new Money(1.0),good.Tax());
    }

    @Test
    public void ShouldVerifyIfNoTaxesAreAppliedForAnExemptedNonImportedGood(){
        Good good = new Good("Book", new Money(10.00), false,true);
        assertEquals(new Money(0.0),good.Tax());
    }

    @Test
    public void ShouldVerifyIfTotalPriceIsCalculatedInculdingTaxesForAGood(){
        Good good = new Good("Book", new Money(10.00), true,false);
        assertEquals(new Money(11.5),good.TotalPrice());
    }

    @Test
    public void ShouldVerifyIfToStringMethodReturnsTheGoodDescription(){
        Good good = new Good("Book", new Money(10.01), true,false);
        assertEquals("Book at 10.01",good.toString());
    }

}