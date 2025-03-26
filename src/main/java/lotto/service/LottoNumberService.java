package lotto.service;

import java.util.List;
import lotto.Lotto;

public interface LottoNumberService {

    void extractLottoNumbers();

    List<Lotto> getLottoList();
}
