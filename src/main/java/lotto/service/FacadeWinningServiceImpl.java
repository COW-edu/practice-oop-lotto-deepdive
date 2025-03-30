package lotto.service;

import static lotto.WinningCount.BONUS_COUNT;
import static lotto.WinningCount.FIVE_COUNT;
import static lotto.WinningCount.FOUR_COUNT;
import static lotto.WinningCount.SIX_COUNT;
import static lotto.WinningCount.THREE_COUNT;
import static lotto.constants.LottoConstants.DEFAULT_WINNING_COUNT;
import static lotto.constants.LottoConstants.PERCENTAGE_MULTIPLIER;
import static lotto.constants.LottoConstants.PERCENTAGE_SCALE;
import static lotto.constants.LottoConstants.WINNING_INCREMENT;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.entity.Lotto;
import lotto.model.WinningRepository;
import lotto.model.entity.LottoResult;

public class FacadeWinningServiceImpl implements FacadeWinningService {

    private final WinningRepository winningRepository;

    public FacadeWinningServiceImpl(WinningRepository winningRepository) {
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

            updateMatchStatistics(matchedCount, hasBonus, matchCountStatistics);
        }
    }

    private void updateMatchStatistics(int matchedCount, boolean hasBonus, Map<Integer, Integer> matchCountStatistics) {
        if (matchedCount == FIVE_COUNT.getCount() && hasBonus) {
            incrementCount(matchCountStatistics, BONUS_COUNT.getCount());
            return;
        }
        if (matchedCount >= THREE_COUNT.getCount()) {
            incrementCount(matchCountStatistics, matchedCount);
        }
    }

    private void incrementCount(Map<Integer, Integer> matchCountStatistics, int key) {
        matchCountStatistics.put(key, matchCountStatistics.getOrDefault(key, DEFAULT_WINNING_COUNT) + WINNING_INCREMENT);
    }

    @Override
    public double getRateOfReturn(int inputMoney) {
        int winningMoney = calculateWinningMoney(winningRepository.getLottoResult());
        double rateOfReturn = (double) winningMoney / inputMoney;
        return roundToTwoDecimalPlaces(convertToPercentage(rateOfReturn));
    }

    private static long convertToPercentage(double rateOfReturn) {
        return Math.round(rateOfReturn * PERCENTAGE_MULTIPLIER);
    }

    private static double roundToTwoDecimalPlaces(double rateOfReturn) {
        BigDecimal rateOfReturnBD = new BigDecimal(rateOfReturn).setScale(PERCENTAGE_SCALE,
                RoundingMode.HALF_UP);
        return rateOfReturnBD.doubleValue();
    }

    @Override
    public LottoResult getLottoResult() {
        return winningRepository.getLottoResult();
    }

    private int calculateWinningMoney(LottoResult lottoResult) {
        return lottoResult.getThreeCount() * THREE_COUNT.getAmount()
                + lottoResult.getFourCount() * FOUR_COUNT.getAmount()
                + lottoResult.getFiveCount() * FIVE_COUNT.getAmount()
                + lottoResult.getBonusCount() * BONUS_COUNT.getAmount()
                + lottoResult.getSixCount() * SIX_COUNT.getAmount();
    }

}
