package Control;
/**
 * @author josevicentecabanas
 */
import java.util.Date;
import Model.Currency;
import Model.ExchangeRate;
import Model.Money;
import Persistence.ExchangeRateLoader;
import Process.MoneyExchanger;
import UI.CurrencyDialog;
import UI.MoneyDialog;
import UI.MoneyDisplay;

public class ExchangeCommand implements Command {
    private MoneyDialog fromMoneyDialog;
    private MoneyDisplay toMoneyDisplay;
    private CurrencyDialog toCurrencyDialog;

    public ExchangeCommand(MoneyDialog fromMoneyDialog, MoneyDisplay toMoneyDisplay, CurrencyDialog toCurrencyDialog) {
        this.fromMoneyDialog = fromMoneyDialog;
        this.toMoneyDisplay = toMoneyDisplay;
        this.toCurrencyDialog = toCurrencyDialog;
    }
    @Override
    public void execute() {
        Money money = fromMoneyDialog.get();
        Currency currency = toCurrencyDialog.get();
        ExchangeRate exchangeRate = new ExchangeRateLoader().get(new Date(), money.getCurrency(), currency);
        Money result = new MoneyExchanger().exchange(money, exchangeRate);
        toMoneyDisplay.show(result);
    }
}