package lotto.model;

import static lotto.constants.ErrorMessage.WINNING_RANGE_ERROR;
import static lotto.constants.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoConstants.MIN_LOTTO_NUMBER;

import java.util.Objects;

public class LottoNumber {
    private final int value;

    private LottoNumber(int value) {
        if (value < MIN_LOTTO_NUMBER || value > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(WINNING_RANGE_ERROR.getMessage());
        }
        this.value = value;
    }

    public static LottoNumber of(int value) {
        return new LottoNumber(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}