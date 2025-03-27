package lotto.service;

import static lotto.WinningCount.BONUS_COUNT;
import static lotto.WinningCount.FIVE_COUNT;
import static lotto.WinningCount.FOUR_COUNT;
import static lotto.WinningCount.SIX_COUNT;
import static lotto.WinningCount.THREE_COUNT;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.entity.Lotto;
import lotto.model.entity.LottoResult;

public class LottoServiceImpl implements LottoService {

    private final FacadeLottoCountService facadeLottoCountService;
    private final FacadeLottoNumberService facadeLottoNumberService;
    private final FacadeWinningService facadeWinningService;

    public LottoServiceImpl(FacadeLottoCountService facadeLottoCountService,
            FacadeLottoNumberService facadeLottoNumberService, FacadeWinningService facadeWinningService) {
        this.facadeLottoCountService = facadeLottoCountService;
        this.facadeLottoNumberService = facadeLottoNumberService;
        this.facadeWinningService = facadeWinningService;
    }


    @Override
    public void purchaseLotto(int money) {
        facadeLottoCountService.saveInputMoney(money);
        int lottoCount = facadeLottoCountService.calculatePurchasedLottoCount(money);
        facadeLottoCountService.saveLottoCount(lottoCount);
        facadeLottoNumberService.extractLottoNumbers(lottoCount);
    }

    @Override
    public void saveWinningNumber(String winningNumber) {
        facadeWinningService.saveWinningNumber(winningNumber);
    }

    @Override
    public void saveBonusNumber(int bonusNumber) {
        facadeWinningService.saveBonusNumber(bonusNumber);
    }

    @Override
    public void matchWinningNumber() {
        List<Lotto> lottoList = facadeLottoNumberService.getLottoList();
        Map<Integer, Integer> lottoCountStatistics = new HashMap<>();
        lottoCountStatistics.put(THREE_COUNT.getCount(), 0);
        lottoCountStatistics.put(FOUR_COUNT.getCount(), 0);
        lottoCountStatistics.put(FIVE_COUNT.getCount(), 0);
        lottoCountStatistics.put(BONUS_COUNT.getCount(), 0);
        lottoCountStatistics.put(SIX_COUNT.getCount(), 0);
        facadeWinningService.matchNumber(lottoList, lottoCountStatistics);
        facadeWinningService.saveLottoResult(lottoCountStatistics);
    }

    @Override
    public double getRateOfReturn() {
        int inputMoney = facadeLottoCountService.getInputMoney();
        return facadeWinningService.getRateOfReturn(inputMoney);
    }

    @Override
    public int getLottoCount() {
        return facadeLottoCountService.getPurchasedLottoCount();
    }

    @Override
    public List<List<Integer>> getLottoList() {
        return facadeLottoNumberService.getLottoList().stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }

    @Override
    public LottoResult getLottoResult() {
        return facadeWinningService.getLottoResult();
    }
}
