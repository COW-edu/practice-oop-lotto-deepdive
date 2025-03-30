package lotto.domain;

import java.util.List;

public class LottoMachine {

    public WinLotto drawingLotto(List<Integer> winNumbers, int bonusNumber) {
        return new WinLotto(winNumbers, bonusNumber);
    }
}
