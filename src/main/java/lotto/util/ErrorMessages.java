package lotto.util;

public class ErrorMessages {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static final String INVALID_LOTTO_NUMBER_COUNT = ERROR_PREFIX + "로또 번호는 6개여야 합니다.";
    public static final String DUPLICATE_LOTTO_NUMBER = ERROR_PREFIX + "로또 번호는 중복될 수 없습니다.";
    public static final String INVALID_LOTTO_NUMBER_RANGE = ERROR_PREFIX + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String INVALID_PURCHASE_AMOUNT = ERROR_PREFIX + "금액은 1,000원 단위여야 합니다.";
    public static final String EMPTY_LOTTO_TICKET_LIST = ERROR_PREFIX + "구매한 로또 티켓 목록은 비어 있을 수 없습니다.";
    public static final String INVALID_AMOUNT_FORMAT = ERROR_PREFIX + "구입 금액은 숫자여야 합니다.";
    public static final String DUPLICATE_BONUS_NUMBER = ERROR_PREFIX + "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final String INVALID_NUMBER_INPUT = ERROR_PREFIX + "입력값은 숫자여야 합니다.";

    private ErrorMessages() {
    }
}
