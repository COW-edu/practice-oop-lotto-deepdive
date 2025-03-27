package lotto.model.entity;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
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
