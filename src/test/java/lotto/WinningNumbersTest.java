package lotto;

import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    @DisplayName("당첨 번호가 올바르게 생성된다.")
    @Test
    void createWinningNumbers() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        WinningNumbers winningNumbers = new WinningNumbers(numbers, bonusNumber);

        // then
        assertThat(winningNumbers.getNumbers()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(winningNumbers.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void validateWinningNumbersSize() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int bonusNumber = 7;

        // then
        assertThatThrownBy(() -> new WinningNumbers(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복이 있으면 예외가 발생한다.")
    @Test
    void validateWinningNumbersDuplicate() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        int bonusNumber = 7;

        // then
        assertThatThrownBy(() -> new WinningNumbers(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void validateWinningNumbersRange(int invalidNumber) {
        // given
        List<Integer> numbers;
        if (invalidNumber == 0) {
            numbers = Arrays.asList(0, 2, 3, 4, 5, 6);
        } else {
            numbers = Arrays.asList(1, 2, 3, 4, 5, 46);
        }
        int bonusNumber = 7;

        // then
        assertThatThrownBy(() -> new WinningNumbers(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void validateBonusNumberRange(int invalidBonusNumber) {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // then
        assertThatThrownBy(() -> new WinningNumbers(numbers, invalidBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void validateBonusNumberDuplicate() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6; // 중복된 보너스 번호

        // then
        assertThatThrownBy(() -> new WinningNumbers(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}