package lotto.service;

import static lotto.WinningCount.BONUS_COUNT;
import static lotto.WinningCount.FIVE_COUNT;
import static lotto.WinningCount.FOUR_COUNT;
import static lotto.WinningCount.SIX_COUNT;
import static lotto.WinningCount.THREE_COUNT;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.LottoCountRepository;
import lotto.model.entity.Lotto;
import lotto.model.WinningRepository;
import lotto.model.entity.LottoResult;

public class FacadeWinningServiceImpl implements FacadeWinningService {

    private final LottoCountRepository lottoCountRepository;
    private final WinningRepository winningRepository;

    public FacadeWinningServiceImpl(LottoCountRepository lottoCountRepository, WinningRepository winningRepository) {
        this.lottoCountRepository = lottoCountRepository;
        this.winningRepository = winningRepository;
    }

    @Override
    public void saveWinningNumber(String winningNumbers) {
        String[] winningNumbersStringList = winningNumbers.split(",");
        List<Integer> winningNumberList = Arrays.stream(winningNumbersStringList)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        winningRepository.saveWinningNumber(winningNumberList);
    }

    @Override
    public void saveBonusNumber(int bonusNumber) {
        winningRepository.saveBonusNumber(bonusNumber);
    }

    @Override
    public void saveLottoResult(Map<Integer, Integer> matchedCountStatistics) {
        LottoResult lottoResult = new LottoResult(
                matchedCountStatistics.get(THREE_COUNT.getCount()),
                matchedCountStatistics.get(FOUR_COUNT.getCount()),
                matchedCountStatistics.get(FIVE_COUNT.getCount()),
                matchedCountStatistics.get(BONUS_COUNT.getCount()),
                matchedCountStatistics.get(SIX_COUNT.getCount())
        );
        winningRepository.saveLottoResult(lottoResult);
    }

    @Override
    public void matchNumber(List<Lotto> lottoList, Map<Integer, Integer> matchCountStatistics) {
        for (Lotto lotto : lottoList) {
            int matchedCount = lotto.matchWinningNumber(winningRepository.getWinningNumber());
            boolean hasBonus = lotto.matchBonusNumber(winningRepository.getBonusNumber());

            matchWinningNumber(matchedCount, hasBonus, matchCountStatistics);
        }
    }

    private void matchWinningNumber(int matchedCount, boolean hasBonus, Map<Integer, Integer> matchCountStatistics) {
        if (matchedCount == FIVE_COUNT.getCount() && hasBonus) {
            matchCountStatistics.put(BONUS_COUNT.getCount(),
                    matchCountStatistics.getOrDefault(BONUS_COUNT.getCount(), 0) + 1);
        } else if (matchedCount >= THREE_COUNT.getCount()) {
            matchCountStatistics.put(matchedCount,
                    matchCountStatistics.getOrDefault(matchedCount, 0) + 1);
        }
    }

    @Override
    public double getRateOfReturn(int inputMoney) {
        int winningMoney = calculateWinningMoney(winningRepository.getLottoResult());
        System.out.println(winningMoney);
        System.out.println(inputMoney);
        double rateOfReturn = (double) winningMoney / inputMoney;
        return Math.round(rateOfReturn*100.0);
    }

    @Override
    public LottoResult getLottoResult() {
        return winningRepository.getLottoResult();
    }

    private int calculateWinningMoney(LottoResult lottoResult) {
        return lottoResult.getThreeCount()*5000 + lottoResult.getFourCount()*50000
                + lottoResult.getFiveCount()*1500000 + lottoResult.getBonusCount()*30000000
                + lottoResult.getSixCount()*2000000000;
    }

}
