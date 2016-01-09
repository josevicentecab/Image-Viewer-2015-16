package Persistence;
/**
 * @author josevicentecabanas
 */
import java.util.ArrayList;
import Model.Currency;

public interface CurrencyReader {
    ArrayList<Currency> get();
}
