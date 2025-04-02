package lotto.constants;

public enum ErrorMessage {
    ERROR("[ERROR] "),
    // 로또 번호 관련 에러
    WINNING_TYPE_ERROR("당첨 번호는 숫자만 입력 가능합니다."),
    WINNING_COUNT_ERROR("당첨 번호는 6개만 입력 가능합니다."),
    WINNING_RANGE_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    WINNING_DUPLICATE_ERROR("당첨 번호에 중복된 숫자가 있습니다."),
    LOTTO_INSTANCE_ERROR("로또 등수 객체가 필요합니다."),

    // 보너스 번호 관련 에러
    BONUS_TYPE_ERROR("보너스 번호는 숫자만 입력 가능합니다."),
    BONUS_RANGE_ERROR("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_DUPLICATE_ERROR("보너스 번호는 당첨 번호와 중복될 수 없습니다."),

    // 금액 관련 에러
    PRICE_TYPE_ERROR("구입 금액은 숫자만 입력 가능합니다."),
    PRICE_MIN_ERROR("구입 금액은 최소 1,000원입니다."),
    PRICE_MAX_ERROR("구입 금액이 너무 큽니다."),
    PRICE_UNIT_ERROR("구입 금액은 1,000원 단위여야 합니다."),
    PRICE_FORMAT("%,d원"),

    //수익률 관련 에러
    PROFIT_RATE_ERROR("수익률은 숫자여야 합니다."),

    // 기타 에러
    INSTANCE_ERROR("유틸리티 클래스는 인스턴스화할 수 없습니다."),
    DEFAULT_ERROR("오류가 발생했습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}