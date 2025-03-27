package lotto;

import lotto.common.AppConfig;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        LottoApplication lottoApplication = appConfig.getLottoApplication();
        lottoApplication.run();
    }
}
