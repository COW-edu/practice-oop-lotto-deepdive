package lotto.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.common.Constant.INVALID_LOTTO_NUMBER;
import static lotto.common.Constant.INVALID_MONEY;

public class Parser {

    public static int toInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INVALID_MONEY);
        }
    }

    public static List<Integer> toList(String winNumbers) {
        try {
            return Arrays.stream(winNumbers.split(", "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INVALID_LOTTO_NUMBER);
        }
    }
}
