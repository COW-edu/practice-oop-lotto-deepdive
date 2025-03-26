package lotto.application.validation;

public interface Validation<T> {
    int validate(T input);
}
