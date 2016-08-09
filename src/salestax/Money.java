package salestax;

public class Money {
    public static final Money ZERO = new Money(0);
    private final double value;

    public Money(double value) {
        this.value = value;
    }

    public Money percentOf(int percent) {
        return new Money(value * (percent/100.0));
    }

    public Money add(Money other) {
        return new Money(this.value+ other.value);
    }

    public Money timesOf(int quantity) {
        return new Money(value*quantity);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        return Double.compare(money.value, value) == 0;

    }
    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(value);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
