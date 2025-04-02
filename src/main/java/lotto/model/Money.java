package lotto.model;

import java.util.Objects;

import static lotto.constants.ErrorMessage.*;
import static lotto.constants.LottoConstants.*;

public class Money {
    private final int amount;

    private Money(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(PRICE_MIN_ERROR.getMessage());
        }
        this.amount = amount;
    }

    public static Money wons(String amountStr) {
        try {
            int amount = Integer.parseInt(amountStr.trim());
            return new Money(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PRICE_TYPE_ERROR.getMessage());
        }
    }

    public void validateLottoAmount() {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(PRICE_MIN_ERROR.getMessage());
        }

        if (amount > LOTTO_LIMIT_PRICE) {
            throw new IllegalArgumentException(PRICE_MAX_ERROR.getMessage());
        }

        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PRICE_UNIT_ERROR.getMessage());
        }
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }

    public Money add(Money other) {
        return new Money(this.amount + other.amount);
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return String.format(PRICE_FORMAT.getMessage(), amount);
    }
}