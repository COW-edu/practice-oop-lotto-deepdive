package lotto.view.formatter;

import java.text.DecimalFormat;

import static lotto.constants.ErrorMessage.PROFIT_RATE_ERROR;

public class RateFormatter implements Formatter {
    private static final String RATE_FORMAT = "0.0";
    private static final String PERCENT = "%";

    @Override
    public String format(Object value) {
        if (!(value instanceof Number)) {
            throw new IllegalArgumentException(PROFIT_RATE_ERROR.getMessage());
        }
        double rate = ((Number) value).doubleValue();
        DecimalFormat formatter = new DecimalFormat(RATE_FORMAT);
        return formatter.format(rate) + PERCENT;
    }
}