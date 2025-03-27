package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.model.entity.Lotto;

public class LottoNumberRepositoryImpl implements LottoNumberRepository {

    private final List<Lotto> lottoList = new ArrayList<>();

    @Override
    public void saveLotto(Lotto lotto) {
        this.lottoList.add(lotto);
    }

    @Override
    public List<Lotto> getLottoList() {
        return this.lottoList;
    }
}
