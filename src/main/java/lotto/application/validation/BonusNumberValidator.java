package lotto.application.validation;

import lotto.util.ErrorMessages;

public class BonusNumberValidator implements NumberValidation<String> {
    @Override
    public int validate(String input) {
        return parseNumber(input);
    }

    private int parseNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_INPUT);
        }
    }
}
