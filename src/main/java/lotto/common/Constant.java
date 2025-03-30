package lotto.common;

public class Constant {

    public static final String PURCHASE_LOTTO = "구입 금액을 입력해주세요.";
    public static final String WIN_NUMBER_LOTTO = "당첨번호를 입력해주세요.";
    public static final String BONUS_NUMBER_LOTTO = "보너스 번호를 입력해주세요.";
    public static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    public static final String INVALID_MONEY = "잘못된 금액 입력입니다.";
    public static final String INVALID_LOTTO_NUMBER = "잘못된 로또 형식입니다.";

    public static final String RESULT_FORMAT = """
                3개 일치 (5,000원) - %d개
                4개 일치 (50,000원) - %d개
                5개 일치 (1,500,000원) - %d개
                5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
                6개 일치 (2,000,000,000원) - %d개
                총 수익률은 %.2f%%입니다.
                """;

    public static final String ERROR = "[ERROR] ";

    public static int TICKET_PRICE = 1000;
    public static int PERCENTAGE_MULTIPLIER = 100;
}
