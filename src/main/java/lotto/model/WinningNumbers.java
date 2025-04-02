package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constants.ErrorMessage.*;
import static lotto.constants.ErrorMessage.WINNING_DUPLICATE_ERROR;
import static lotto.constants.LottoConstants.*;
import static lotto.constants.LottoConstants.LOTTO_SIZE;

public class WinningNumbers {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        validateLottoNumbers(numbers);
        validateBonusNumber(bonusNumber, numbers);

        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateLottoNumbers(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(WINNING_TYPE_ERROR.getMessage());
        }

        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(WINNING_COUNT_ERROR.getMessage());
        }

        if (numbers.stream().anyMatch(n -> n < MIN_LOTTO_NUMBER || n > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(WINNING_RANGE_ERROR.getMessage());
        }

        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException(WINNING_DUPLICATE_ERROR.getMessage());
        }
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(BONUS_RANGE_ERROR.getMessage());
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE_ERROR.getMessage());
        }
    }

}