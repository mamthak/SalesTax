package salestax;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoneyTest {

    @Test
    public void shouldBeAbleToCalculatePercentageOfMoney(){
        assertEquals(new Money(1.0), new Money(10.00).percentOf(10));
    }

    @Test
    public void shouldBeAbleToAddMonies(){
        assertEquals(new Money(11.0), new Money(10.00).add(new Money(1.0)));
    }

    @Test
    public void shouldBeAbleToGiveNTimesOfMoney(){
        assertEquals(new Money(50.0), new Money(10.00).timesOf(5));
    }

    @Test
    public void shouldBeAbleToVerifyIfToStringMethodReturnTheValue(){
        assertEquals("10.12", new Money(10.12).toString());
    }
}