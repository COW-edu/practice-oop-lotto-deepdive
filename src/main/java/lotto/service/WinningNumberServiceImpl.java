package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.model.WinningNumberRepository;

public class WinningNumberServiceImpl implements WinningNumberService {

    private final WinningNumberRepository winningNumberRepository;

    public WinningNumberServiceImpl(WinningNumberRepository winningNumberRepository) {
        this.winningNumberRepository = winningNumberRepository;
    }

    @Override
    public void saveWinningNumber(String winningNumbers) {
        String[] winningNumbersStringList = winningNumbers.split(",");
        List<Integer> winningNumberList = Arrays.stream(winningNumbersStringList)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        winningNumberRepository.saveWinningNumber(winningNumberList);
    }

    @Override
    public void saveBonusNumber(int bonusNumber) {
        winningNumberRepository.saveBonusNumber(bonusNumber);
    }

    @Override
    public void matchNumber(List<Lotto> lottoList) {
    }

    @Override
    public float getRateOfReturn() {
        return 0;
    }

    @Override
    public int getThreeCount() {
        return 0;
    }

    @Override
    public int getFourCount() {
        return 0;
    }

    @Override
    public int getFiveCount() {
        return 0;
    }

    @Override
    public int getBonusCount() {
        return 0;
    }

    @Override
    public int getSixCount() {
        return 0;
    }
}
