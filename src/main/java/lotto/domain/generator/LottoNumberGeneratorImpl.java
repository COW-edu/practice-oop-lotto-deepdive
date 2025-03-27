package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.LottoConstants;

import java.util.List;

public class LottoNumberGeneratorImpl implements LottoNumberGenerator {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_LOTTO_NUMBER, LottoConstants.MAX_LOTTO_NUMBER, LottoConstants.LOTTO_NUMBER_COUNT);
    }
}
