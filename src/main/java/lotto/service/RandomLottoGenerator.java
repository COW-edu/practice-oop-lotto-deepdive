package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.LottoConstants.*;

public class RandomLottoGenerator implements LottoGenerator {
    @Override
    public List<Lotto> generate(int count) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
            lottoTickets.add(new Lotto(numbers));
        }
        return lottoTickets;
    }
}
