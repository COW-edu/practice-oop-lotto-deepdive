package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.model.entity.LottoResult;

public class WinningRepositoryImpl implements WinningRepository {

    private final List<Integer> numbers = new ArrayList<Integer>();
    private int bonusNumber;
    private LottoResult lottoResult;

    @Override
    public void saveWinningNumber(List<Integer> numbers) {
        this.numbers.addAll(numbers);
    }

    @Override
    public void saveBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    @Override
    public void saveLottoResult(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
    }

    @Override
    public List<Integer> getWinningNumber() {
        return this.numbers;
    }

    @Override
    public int getBonusNumber() {
        return this.bonusNumber;
    }

    @Override
    public LottoResult getLottoResult() {
        return this.lottoResult;
    }
}
