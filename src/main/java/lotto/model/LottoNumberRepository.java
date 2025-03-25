package lotto.model;

import java.util.List;
import lotto.Lotto;

public interface LottoNumberRepository {

    void saveLotto(Lotto lotto);

    List<Lotto> getLottoList();
}
