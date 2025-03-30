package lotto.controller;

import java.util.List;

public interface LottoController {
    void purchaseLotto(int money);

    void saveWinningNumber(String winningNumber);

    void saveBonusNumber(int bonusNumber);

    void matchWinningNumber();

    double getRateOfReturn();

    int getPurchasedLottoCount();

    List<List<Integer>> getLottoList();

    int getThreeCount();

    int getFourCount();

    int getFiveCount();

    int getBonusCount();

    int getSixCount();
}
