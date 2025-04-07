package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.model.entity.Lotto;
import lotto.model.entity.LottoResult;

public interface FacadeWinningService {

    void saveWinningNumber(String winningNumbers);

    void saveBonusNumber(int bonusNumber);

    void saveLottoResult(Map<Integer, Integer> lottoCountStatistics);

    void matchNumber(List<Lotto> lottoList, Map<Integer, Integer> matchCountStatistics);

    double getRateOfReturn(int inputMoney);

    LottoResult getLottoResult();
}
