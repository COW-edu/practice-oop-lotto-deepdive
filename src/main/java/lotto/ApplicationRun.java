package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ApplicationRun {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoController lottoController;

    public ApplicationRun(InputView inputView, OutputView outputView, LottoController lottoController) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoController = lottoController;
    }

    public void run() {
        int money = inputView.inputMoney();
        lottoController.purchaseLotto(money);

        outputView.outputPurchasedLottoCount();
        outputView.outputPurchasedLottoNumbers();

        String winningNumber = inputView.inputWinningNumber();
        lottoController.saveWinningNumber(winningNumber);

        int bonusNumber = inputView.inputBonusNumber();
        lottoController.saveBonusNumber(bonusNumber);

        lottoController.matchWinningNumber();

        outputView.outputWinningDetail();
        outputView.outputRateOfReturn();
    }
}
