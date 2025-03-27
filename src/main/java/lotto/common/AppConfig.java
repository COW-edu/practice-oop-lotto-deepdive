package lotto.common;

import lotto.LottoApplication;
import lotto.domain.Calculator;
import lotto.domain.LottoMatcher;
import lotto.domain.LottoMachine;
import lotto.domain.LottoStore;
import lotto.handler.InputHandler;
import lotto.handler.OutputHandler;

public class AppConfig {

    private final LottoApplication lottoApplication = new LottoApplication(lottoMachine(), lottoStore(), lottoMatcher(), calculator(), inputView(), outputView());

    public LottoApplication getLottoApplication() {
        return lottoApplication;
    }

    private LottoStore lottoStore() {
        return new LottoStore();
    }

    private LottoMachine lottoMachine() {
        return new LottoMachine();
    }

    private LottoMatcher lottoMatcher() {
        return new LottoMatcher();
    }

    private Calculator calculator() {
        return new Calculator();
    }

    private InputHandler inputView() {
        return new InputHandler();
    }

    private OutputHandler outputView() {
        return new OutputHandler();
    }
}
