package lotto.service;

public interface FacadeLottoCountService {

    int calculatePurchasedLottoCount(int money);

    int getPurchasedLottoCount();

    void saveLottoCount(int lottoCount);

    void saveInputMoney(int money);

    int getInputMoney();
}
