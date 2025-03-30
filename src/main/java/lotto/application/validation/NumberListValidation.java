package lotto.application.validation;

import java.util.List;

public interface NumberListValidation<T> {
    List<Integer> validate(T input);
}
