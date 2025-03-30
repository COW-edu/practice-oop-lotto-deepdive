package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class ApplicationRun {

    private final InputView inputView;
    private final OutputView outputView;

    public ApplicationRun(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        inputView.inputMoney();

        outputView.outputPurchasedLottoCount();
        outputView.outputPurchasedLottoNumbers();

        inputView.inputWinningNumber();

        inputView.inputBonusNumber();

        outputView.outputWinningDetail();
        outputView.outputRateOfReturn();
    }
}
