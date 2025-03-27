package lotto.service;

import lotto.model.LottoCountRepository;

public class FacadeLottoCountServiceImpl implements FacadeLottoCountService {

    private final LottoCountRepository lottoCountRepository;

    public FacadeLottoCountServiceImpl(LottoCountRepository lottoCountRepository) {
        this.lottoCountRepository = lottoCountRepository;
    }

    @Override
    public int calculatePurchasedLottoCount(int money) {
        return money / 1000;
    }

    @Override
    public int getPurchasedLottoCount() {
        return lottoCountRepository.getLottoCount();
    }

    @Override
    public void saveLottoCount(int lottoCount) {
        this.lottoCountRepository.saveLottoCount(lottoCount);
    }

    @Override
    public void saveInputMoney(int money) {
        this.lottoCountRepository.saveInputMoney(money);
    }

    @Override
    public int getInputMoney() {
        return lottoCountRepository.getInputMoney();
    }

}
