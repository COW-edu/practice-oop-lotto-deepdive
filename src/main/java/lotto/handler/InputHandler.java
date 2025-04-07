package lotto.handler;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.Parser;

import java.util.List;

import static lotto.common.Constant.*;

public class InputHandler {

    public int printPurchaseAmountPrompt() {
        System.out.println(PURCHASE_LOTTO);
        return Parser.toInt(Console.readLine());
    }

    public List<Integer> printWinNumberPrompt() {
        System.out.println(WIN_NUMBER_LOTTO);
        return Parser.toList(Console.readLine());
    }

    public int printBonusNumberPrompt() {
        System.out.println(BONUS_NUMBER_LOTTO);
        return Parser.toInt(Console.readLine());
    }
}
