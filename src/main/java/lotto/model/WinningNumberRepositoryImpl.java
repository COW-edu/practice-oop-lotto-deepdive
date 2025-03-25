package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberRepositoryImpl implements WinningNumberRepository {

    private final List<Integer> numbers = new ArrayList<Integer>();
    private int bonusNumber;

    @Override
    public void saveWinningNumber(List<Integer> numbers) {
        this.numbers.addAll(numbers);
    }

    @Override
    public void saveBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
