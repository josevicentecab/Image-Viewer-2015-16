package Persistence;
/**
 * @author josevicentecabanas
 */
import java.util.Date;
import Model.Currency;
import Model.ExchangeRate;

public interface ExchangeRateReader {
    ExchangeRate get(Date date, Currency from, Currency to);
}
