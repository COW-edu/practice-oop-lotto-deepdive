package lotto;

import lotto.domain.*;
import lotto.domain.Lotto;
import lotto.handler.InputHandler;
import lotto.handler.OutputHandler;

import java.util.List;

public class LottoApplication {

    private final LottoStore lottoStore;
    private final LottoMachine lottoMachine;
    private final LottoMatcher lottoMatcher;
    private final Calculator calculator;

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    private List<Lotto> lottoList;
    private WinLotto winLotto;

    public LottoApplication(
            LottoMachine lottoMachine,
            LottoStore lottoStore,
            LottoMatcher lottoMatcher,
            Calculator calculator,
            InputHandler inputHandler,
            OutputHandler outputHandler
    ) {
        this.lottoMachine = lottoMachine;
        this.lottoStore = lottoStore;
        this.lottoMatcher = lottoMatcher;
        this.calculator = calculator;
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        try{
            purchaseLotto();
            generateWinLotto();
            compareResult();
            calculateProfitRate();
            printResult();
        } catch (IllegalArgumentException e) {
            outputHandler.printException(e.getMessage());
        }
    }

    private void purchaseLotto() {
        int money = inputHandler.printPurchaseAmountPrompt();
        lottoList = lottoStore.createLotto(money);

        outputHandler.printPurchaseCount(lottoList.size());
        outputHandler.printAllLottoNumber(lottoList);
    }

    private void generateWinLotto() {
        List<Integer> winNumbers = inputHandler.printWinNumberPrompt();
        int bonusNumber = inputHandler.printBonusNumberPrompt();
        winLotto = lottoMachine.drawingLotto(winNumbers, bonusNumber);
    }

    private void compareResult() {
        lottoMatcher.compareLotto(lottoList, winLotto);
    }

    private void calculateProfitRate() {
        calculator.getRateOfReturn(lottoMatcher.getRankCount());
    }

    private void printResult() {
        outputHandler.printResult(lottoMatcher.getRankCount(), calculator.getRecord());
    }
}
