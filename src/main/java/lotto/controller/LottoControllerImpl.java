package lotto.controller;

import java.util.List;
import lotto.service.LottoService;

public class LottoControllerImpl implements LottoController {

    private final LottoService lottoService;

    public LottoControllerImpl(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    @Override
    public void purchaseLotto(int money) {
        lottoService.purchaseLotto(money);
    }

    @Override
    public void saveWinningNumber(String winningNumber) {
        lottoService.saveWinningNumber(winningNumber);
    }

    @Override
    public void saveBonusNumber(int bonusNumber) {
        lottoService.saveBonusNumber(bonusNumber);
    }

    @Override
    public void matchWinningNumber() {
        lottoService.matchWinningNumber();
    }

    @Override
    public double getRateOfReturn() {
        return lottoService.getRateOfReturn();
    }

    @Override
    public int getPurchasedLottoCount() {
        return lottoService.getLottoCount();
    }

    @Override
    public List<List<Integer>> getLottoList() {
        return lottoService.getLottoList();
    }

    @Override
    public int getThreeCount() {
        return lottoService.getLottoResult().getThreeCount();
    }

    @Override
    public int getFourCount() {
        return lottoService.getLottoResult().getFourCount();
    }

    @Override
    public int getFiveCount() {
        return lottoService.getLottoResult().getFiveCount();
    }

    @Override
    public int getBonusCount() {
        return lottoService.getLottoResult().getBonusCount();
    }

    @Override
    public int getSixCount() {
        return lottoService.getLottoResult().getSixCount();
    }
}
