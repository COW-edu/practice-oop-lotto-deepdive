package lotto;

import lotto.constants.LottoRank;
import lotto.dto.LottosDTO;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningNumbers;
import lotto.service.ResultService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultServiceTest {

    private ResultService resultService;

    @BeforeEach
    void setUp() {
        resultService = new ResultService();
    }

    @DisplayName("로또 결과를 올바르게 계산한다.")
    @Test
    void calculateResult() {
        // given
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 6개 일치 (1등)
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 5개 일치 + 보너스 (2등)
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)), // 5개 일치 (3등)
                new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10)), // 4개 일치 (4등)
                new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13)), // 3개 일치 (5등)
                new Lotto(Arrays.asList(1, 2, 14, 15, 16, 17)) // 2개 일치 (낙첨)
        );

        LottosDTO lottosDTO = new LottosDTO(lottos);
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        // when
        LottoResult result = resultService.calculateResult(lottosDTO, winningNumbers);

        // then
        assertThat(result.getCount(LottoRank.FIRST)).isEqualTo(1);
        assertThat(result.getCount(LottoRank.SECOND)).isEqualTo(1);
        assertThat(result.getCount(LottoRank.THIRD)).isEqualTo(1);
        assertThat(result.getCount(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(result.getCount(LottoRank.FIFTH)).isEqualTo(1);
    }

    @DisplayName("수익률을 올바르게 계산한다.")
    @Test
    void calculateReturnRate() {
        // given
        LottoResult result = new LottoResult();
        result.addRank(LottoRank.FIRST); // 20억

        int purchaseAmount = 5000; // 5장 구매 = 5,000원

        // when
        double returnRate = resultService.calculateReturnRate(result, purchaseAmount);

        // then
        // 20억 / 5000 * 100 = 40,000,000%
        assertThat(returnRate).isEqualTo(40_000_000.0);
    }

    @DisplayName("구매 금액이 0원일 경우 수익률은 0%이다.")
    @Test
    void calculateReturnRateWithZeroPurchase() {
        // given
        LottoResult result = new LottoResult();
        result.addRank(LottoRank.FIRST);

        // when
        double returnRate = resultService.calculateReturnRate(result, 0);

        // then
        assertThat(returnRate).isEqualTo(0.0);
    }
}