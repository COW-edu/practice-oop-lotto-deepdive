package lotto.service;

import java.util.List;
import lotto.entity.Lotto;

public interface LottoNumberService {

    void extractLottoNumbers(int lottoCount);

    List<Lotto> getLottoList();
}
