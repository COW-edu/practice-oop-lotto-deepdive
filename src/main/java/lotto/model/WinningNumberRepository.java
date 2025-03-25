package lotto.model;

import java.util.List;

public interface WinningNumberRepository {

    void saveWinningNumber(List<Integer> numbers);

    void saveBonusNumber(int bonusNumber);
}
