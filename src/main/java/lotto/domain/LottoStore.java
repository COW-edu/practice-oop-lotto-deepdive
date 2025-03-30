package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.common.Constant.INVALID_MONEY;
import static lotto.common.Constant.TICKET_PRICE;

public class LottoStore {

    public List<Lotto> createLotto(int money) {
        validateMoney(money);
        int lottoCount = calculateLottoCount(money);

        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(createRandomNumbers()))
                .collect(Collectors.toList());
    }

    private void validateMoney(int amount) {
        if (amount <= 0 || amount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_MONEY);
        }
    }

    private int calculateLottoCount(int amount) {
        return amount / TICKET_PRICE;
    }

    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
