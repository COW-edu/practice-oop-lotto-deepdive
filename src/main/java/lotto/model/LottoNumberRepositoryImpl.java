package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoNumberRepositoryImpl implements LottoNumberRepository {

    private final List<Lotto> lottoList = new ArrayList<Lotto>();

    @Override
    public void saveLotto(Lotto lotto) {
        this.lottoList.add(lotto);
    }

    @Override
    public List<Lotto> getLottoList() {
        return this.lottoList;
    }
}
