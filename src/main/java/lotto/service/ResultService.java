package lotto.service;

import lotto.constants.LottoRank;
import lotto.dto.LottosDTO;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningNumbers;

public class ResultService {

    public LottoResult calculateResult(LottosDTO lottos, WinningNumbers winningNumbers) {
        LottoResult result = new LottoResult();
        Lotto winningLotto = new Lotto(winningNumbers.getNumbers());

        for (Lotto ticket : lottos.getLottos()) {
            int matchCount = ticket.matchCount(winningLotto);
            boolean bonusMatch = ticket.contains(winningNumbers.getBonusNumber());
            LottoRank rank = LottoRank.from(matchCount, bonusMatch);
            result.addRank(rank);
        }

        return result;
    }

    public double calculateReturnRate(LottoResult result, int purchaseAmount) {
        return result.calculateReturnRate(purchaseAmount);
    }
}