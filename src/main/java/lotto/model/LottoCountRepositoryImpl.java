package lotto.model;

public class LottoCountRepositoryImpl implements LottoCountRepository {

    private int inputMoney;
    private int lottoCount;

    @Override
    public void saveInputMoney(int money) {
        this.inputMoney = money;
    }

    @Override
    public void saveLottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    @Override
    public int getLottoCount() {
        return this.lottoCount;
    }

    @Override
    public int getInputMoney() {
        return this.inputMoney;
    }


}
