package lotto;

import lotto.adapter.in.console.ConsoleLottoController;
import lotto.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        ConsoleLottoController controller = config.consoleLottoController();
        controller.run();
    }
}
