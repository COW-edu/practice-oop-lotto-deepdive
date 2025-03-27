package lotto.model.entity;

import static lotto.constants.LottoConstants.LOTTO_SIZE;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
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
