package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.ErrorMessage.*;
import static lotto.constants.LottoConstants.*;

public class ParsorUtil {

    private ParsorUtil() {
        throw new IllegalStateException(INSTANCE_ERROR.getMessage());
    }

    public static int parseToInt(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_TYPE_ERROR.getMessage());
        }
    }

    public static List<Integer> parseNumbersList(String input) {
        try {
            return Arrays.stream(input.split(COMMA))
                    .map(String::trim)
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (Exception e) {
    throw new IllegalArgumentException(WINNING_TYPE_ERROR.getMessage());
        }
    }
}