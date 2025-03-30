package lotto.service;

import java.util.List;
import lotto.model.entity.LottoResult;

public interface LottoService {

    void purchaseLotto(int money);

    void saveWinningNumber(String winningNumber);

    void saveBonusNumber(int bonusNumber);

    void matchWinningNumber();

    double getRateOfReturn();

    int getLottoCount();

    List<List<Integer>> getLottoList();

    LottoResult getLottoResult();
}
