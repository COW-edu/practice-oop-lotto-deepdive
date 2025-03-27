package lotto.model;

import java.util.List;
import lotto.model.entity.Lotto;

public interface LottoNumberRepository {

    void saveLotto(Lotto lotto);

    List<Lotto> getLottoList();
}
