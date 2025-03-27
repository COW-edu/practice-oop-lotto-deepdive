package lotto.domain;

import java.util.List;

public class WinLotto {

    private final List<Integer> lotto;
    private final int bonus;

    public WinLotto(List<Integer> lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }
}
