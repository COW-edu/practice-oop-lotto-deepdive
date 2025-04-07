package lotto;

import lotto.common.AppConfig;

public class Application {

    public static void main(String[] args) {
        LottoApplication lottoApplication = AppConfig.getInstance().getLottoApplication();
        lottoApplication.run();
    }
}
