package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("invalidSizeLottoNumbers")
    void createLottoWithInvalidSize(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoWithDuplicateNumber() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("outOfRangeLottoNumbers")
    void createLottoWithOutOfRangeNumber(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 올바르게 생성된다.")
    @Test
    void createLottoWithValidNumbers() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = new Lotto(numbers);

        // then
        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    @DisplayName("로또 번호가 자동으로 정렬된다.")
    @Test
    void lottoNumbersShouldBeSorted() {
        // given
        List<Integer> unsortedNumbers = Arrays.asList(6, 1, 3, 5, 4, 2);
        List<Integer> expectedSortedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = new Lotto(unsortedNumbers);

        // then
        assertThat(lotto.getNumbers()).isEqualTo(expectedSortedNumbers);
    }

    @DisplayName("다른 로또와 일치하는 번호의 개수를 정확히 계산한다.")
    @Test
    void countMatchingNumbers() {
        // given
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));

        // when
        int matchCount = lotto1.matchCount(lotto2);

        // then
        assertThat(matchCount).isEqualTo(3);
    }

    @DisplayName("특정 번호가 로또에 포함되어 있는지 정확히 확인한다.")
    @Test
    void containsNumber() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // then
        assertThat(lotto.contains(1)).isTrue();
        assertThat(lotto.contains(7)).isFalse();
    }

    static Stream<Arguments> invalidSizeLottoNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }

    static Stream<Arguments> outOfRangeLottoNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(0, 2, 3, 4, 5, 6)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 46))
        );
    }
}
