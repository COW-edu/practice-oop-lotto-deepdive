package lotto.service;

import java.util.List;
import lotto.model.entity.Lotto;

public interface FacadeLottoNumberService {

    void extractLottoNumbers(int lottoCount);

    List<Lotto> getLottoList();
}
