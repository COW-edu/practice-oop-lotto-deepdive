package lotto.controller;

import lotto.model.LottoCountRepository;

public class LottoCountControllerImpl implements LottoCountController {

    private final LottoCountRepository lottoCountRepository;

    public LottoCountControllerImpl(LottoCountRepository lottoCountRepository) {
        this.lottoCountRepository = lottoCountRepository;
    }

    @Override
    public void calculatePurchasedLottoCount(int money) {
        int purchaseCount = money / 1000;
        lottoCountRepository.saveLottoCount(purchaseCount);
    }

    @Override
    public int getPurchasedLottoCount() {
        return lottoCountRepository.getLottoCount();
    }
}
