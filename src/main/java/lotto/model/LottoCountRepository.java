package lotto.model;

public interface LottoCountRepository {

    void saveInputMoney(int money);

    void saveLottoCount(int lottoCount);

    int getLottoCount();

    int getInputMoney();
}
