package lotto.util;

public class ErrorMessages {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static final String INVALID_LOTTO_NUMBER_COUNT = ERROR_PREFIX + "로또 번호는 6개여야 합니다.";
    public static final String DUPLICATE_LOTTO_NUMBER = ERROR_PREFIX + "로또 번호는 중복될 수 없습니다.";
    public static final String INVALID_LOTTO_NUMBER_RANGE = ERROR_PREFIX + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

}
