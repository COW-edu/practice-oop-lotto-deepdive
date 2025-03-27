package lotto.application.validation;

import lotto.util.ErrorMessages;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberValidator implements NumberListValidation<String> {

    @Override
    public List<Integer> validate(String input) {
        return parseNumbers(input);
    }

    private List<Integer> parseNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_INPUT);
        }
    }
}
