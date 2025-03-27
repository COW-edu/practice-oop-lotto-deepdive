package lotto.domain.model;

import lotto.util.ErrorMessages;
import lotto.util.LottoConstants;

import java.util.HashSet;
import java.util.List;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        validateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_COUNT);
        }
        if (new HashSet<>(numbers).size() != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_LOTTO_NUMBER);
        }
        if (numbers.stream().anyMatch(n -> n < LottoConstants.MIN_LOTTO_NUMBER || n > LottoConstants.MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE);
        }
    }

    private void validateBonusNumber(List<Integer> winningNumbers, int bonus) {
        if (bonus < LottoConstants.MIN_LOTTO_NUMBER || bonus > LottoConstants.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE);
        }
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_BONUS_NUMBER);
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}