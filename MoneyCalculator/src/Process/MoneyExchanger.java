package Process;
/**
 * @author josevicentecabanas
 */
import Model.ExchangeRate;
import Model.Money;

public class MoneyExchanger {
    public Money exchange(Money money, ExchangeRate exchangeRate) {
        return new Money(money.getAmount() * exchangeRate.getRate(), exchangeRate.getTo());
    }
}