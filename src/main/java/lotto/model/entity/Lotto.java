package lotto.model.entity;

import static lotto.constants.ErrorMessages.DUPLICATED_NUMBER_ERROR_MESSAGE;
import static lotto.constants.ErrorMessages.EXCEED_LOTTO_SIZE_ERROR_MESSAGE;
import static lotto.constants.LottoConstants.LOTTO_SIZE;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(EXCEED_LOTTO_SIZE_ERROR_MESSAGE);
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = numbers.stream().collect(Collectors.toSet());
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int matchWinningNumber(List<Integer> winningNumber) {
        return (int) this.numbers.stream()
                .filter(winningNumber::contains)
                .count();
    }

    public boolean matchBonusNumber(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }
}
