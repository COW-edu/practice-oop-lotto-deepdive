package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static lotto.common.Constant.INVALID_LOTTO_NUMBER;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sorted(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER);
        }
    }

    private List<Integer> sorted(List<Integer> numbers) {
        List<Integer> sortedList = new ArrayList<>(numbers);
        Collections.sort(sortedList);
        return sortedList;
    }
}
