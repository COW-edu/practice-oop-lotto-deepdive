package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoCountController;
import lotto.controller.WinningNumberController;

public class InputViewImpl implements InputView {

    private final LottoCountController lottoCountController;
    private final WinningNumberController winningNumberController;

    public InputViewImpl(LottoCountController lottoCountController,
            WinningNumberController winningNumberController) {
        this.lottoCountController = lottoCountController;
        this.winningNumberController = winningNumberController;
    }

    @Override
    public void inputMoney() {
        System.out.print("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        lottoCountController.calculatePurchasedLottoCount(money);
    }

    @Override
    public void inputWinningNumber() {
        System.out.print("당첨 번호를 입력해 주세요.");
        String winningNumber = Console.readLine();
        winningNumberController.saveWinningNumber(winningNumber);
    }

    @Override
    public void inputBonusNumber() {
        System.out.print("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        winningNumberController.saveBonusNumber(bonusNumber);
    }
}
