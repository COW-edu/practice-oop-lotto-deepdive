
package lotto.service;

import lotto.util.ParsorUtil;
import lotto.model.WinningNumbers;
import java.util.List;

public class WinningNumbersService {

    public WinningNumbers createWinningNumbers(String winningNumbersInput, String bonusNumberInput) {
        List<Integer> numbers = ParsorUtil.parseNumbersList(winningNumbersInput);
        int bonusNumber = ParsorUtil.parseToInt(bonusNumberInput);

        return new WinningNumbers(numbers, bonusNumber);
    }
}