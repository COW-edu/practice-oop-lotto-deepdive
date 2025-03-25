package lotto.model;

public interface LottoCountRepository {

    void saveLottoCount(int lottoCount);

    int getLottoCount();
}
