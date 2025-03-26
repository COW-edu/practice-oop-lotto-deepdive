package lotto.service;

import lotto.model.LottoCountRepository;

public class LottoCountServiceImpl implements LottoCountService {

    private final LottoCountRepository lottoCountRepository;

    public LottoCountServiceImpl(LottoCountRepository lottoCountRepository) {
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
