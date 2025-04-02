package lotto.view.formatter;

import java.text.DecimalFormat;

import static lotto.constants.ErrorMessage.PRICE_TYPE_ERROR;

public class MoneyFormatter implements Formatter {
    private static final String MONEY_FORMAT = "#,###";
    private static final String WON = "원";

    @Override
    public String format(Object value) {
        if (!(value instanceof Number)) {
            throw new IllegalArgumentException(PRICE_TYPE_ERROR.getMessage());
        }
        int amount = ((Number) value).intValue();
        DecimalFormat formatter = new DecimalFormat(MONEY_FORMAT);
        return formatter.format(amount) + WON;
    }
}
