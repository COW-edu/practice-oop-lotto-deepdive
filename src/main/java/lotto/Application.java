package lotto;

import lotto.config.AppConfig;
import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.InputViewImpl;
import lotto.view.OutputView;
import lotto.view.OutputViewImpl;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        LottoController lottoController = appConfig.lottoController();
        InputView inputView = new InputViewImpl(lottoController);
        OutputView outputView = new OutputViewImpl(lottoController);

        ApplicationRun applicationRun = new ApplicationRun(inputView, outputView);
        applicationRun.run();
    }
}
