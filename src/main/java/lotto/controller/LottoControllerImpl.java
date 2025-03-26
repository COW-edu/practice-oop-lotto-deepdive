package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.service.LottoCountService;
import lotto.service.LottoNumberService;
import lotto.service.WinningNumberService;

public class LottoControllerImpl implements LottoController {

    private final LottoCountService lottoCountService;
    private final LottoNumberService lottoNumberService;
    private final WinningNumberService winningNumberService;

    LottoControllerImpl(LottoCountService lottoCountService, LottoNumberService lottoNumberService,
            WinningNumberService winningNumberService) {
        this.lottoCountService = lottoCountService;
        this.lottoNumberService = lottoNumberService;
        this.winningNumberService = winningNumberService;
    }

    @Override
    public void purchaseLotto(int money) {
        lottoCountService.calculatePurchasedLottoCount(money);
        lottoNumberService.extractLottoNumbers();
    }

    @Override
    public void saveWinningNumber(String winningNumber) {
        winningNumberService.saveWinningNumber(winningNumber);
    }

    @Override
    public void saveBonusNumber(int bonusNumber) {
        winningNumberService.saveBonusNumber(bonusNumber);
    }

    @Override
    public void matchWinningNumber() {
        List<Lotto> lottoList = lottoNumberService.getLottoList();
        winningNumberService.matchNumber(lottoList);
    }
}
