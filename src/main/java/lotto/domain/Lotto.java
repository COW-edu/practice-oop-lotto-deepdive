package lotto.domain;

import java.util.HashSet;
import java.util.List;

import static lotto.common.Constant.INVALID_LOTTO_NUMBER;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER);
        }
    }
}
