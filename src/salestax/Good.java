package salestax;

public class Good {


    public static final int TAX_PERCENT = 10;
    private static final int IMPORTED_TAX_PERCENT = 5;
    private final String name;
    private final Money price;
    private final boolean isImported;
    private final boolean isExempted;

    public Good(String name, Money price, boolean isImported, boolean IsExempted) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        isExempted = IsExempted;
    }

    public Money Tax() {
        return SalesTax().add(ImportedSalesTax());
    }

    public Money TotalPrice() {
        return price.add(Tax());
    }

    private Money SalesTax() {

        if (isExempted)
            return Money.ZERO;
        return price.percentOf(TAX_PERCENT);
    }

    private Money ImportedSalesTax() {
        if (!isImported)
            return Money.ZERO;
        return price.percentOf(IMPORTED_TAX_PERCENT);
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.name, this.price.toString());
    }
}
