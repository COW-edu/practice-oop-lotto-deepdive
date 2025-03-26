package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView {

    @Override
    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    @Override
    public String inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    @Override
    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
