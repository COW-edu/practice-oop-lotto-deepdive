package lotto.view;

import static lotto.constants.InputViewConstants.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.constants.InputViewConstants.INPUT_MONEY_MESSAGE;
import static lotto.constants.InputViewConstants.INPUT_WINNING_NUMBER_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;

public class InputViewImpl implements InputView {

    private final LottoController lottoController;

    public InputViewImpl(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    @Override
    public void inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        int money = Integer.parseInt(Console.readLine());
        lottoController.purchaseLotto(money);
    }

    @Override
    public void inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        lottoController.saveWinningNumber(Console.readLine());
    }

    @Override
    public void inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        lottoController.saveBonusNumber(Integer.parseInt(Console.readLine()));
    }
}
