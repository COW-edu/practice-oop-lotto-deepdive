package lotto.application.validation;

import lotto.util.ErrorMessages;

public class AmountValidator implements NumberValidation<String> {
    @Override
    public int validate(String input) {
        return validateAndParseAmount(input);
    }

    private int validateAndParseAmount(String amountInput) {
        try {
            return Integer.parseInt(amountInput);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessages.INVALID_AMOUNT_FORMAT);
        }
    }
}
