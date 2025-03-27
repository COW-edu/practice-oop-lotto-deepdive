package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;

public class InputViewImpl implements InputView {

    private final LottoController lottoController;

    public InputViewImpl(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    @Override
    public void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        lottoController.purchaseLotto(money);
    }

    @Override
    public void inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        lottoController.saveWinningNumber(Console.readLine());
    }

    @Override
    public void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        lottoController.saveBonusNumber(Integer.parseInt(Console.readLine()));
    }
}
