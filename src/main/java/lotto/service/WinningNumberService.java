package lotto.service;

import java.util.List;
import lotto.Lotto;

public interface WinningNumberService {

    void saveWinningNumber(String winningNumbers);

    void saveBonusNumber(int bonusNumber);

    void matchNumber(List<Lotto> lottoList);

    float getRateOfReturn();

    int getThreeCount();

    int getFourCount();

    int getFiveCount();

    int getBonusCount();

    int getSixCount();
}
