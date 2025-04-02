package lotto.model;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.ErrorMessage.*;
import static lotto.constants.LottoConstants.LOTTO_SIZE;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);

        this.numbers = numbers.stream()
                .map(LottoNumber::of)
                .sorted(Comparator.comparing(LottoNumber::getValue))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.toList());
    }

    public int matchCount(Lotto other) {
        return (int) this.numbers.stream()
                .filter(number -> other.contains(number.getValue()))
                .count();
    }

    public boolean contains(int number) {
        return numbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.getValue() == number);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers == null || numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(WINNING_COUNT_ERROR.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(WINNING_DUPLICATE_ERROR.getMessage());
        }
    }
}