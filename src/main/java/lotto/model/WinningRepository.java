package lotto.model;

import java.util.List;
import lotto.model.entity.LottoResult;

public interface WinningRepository {

    void saveWinningNumber(List<Integer> numbers);

    void saveBonusNumber(int bonusNumber);

    void saveLottoResult(LottoResult lottoResult);

    List<Integer> getWinningNumber();

    int getBonusNumber();

    LottoResult getLottoResult();
}
