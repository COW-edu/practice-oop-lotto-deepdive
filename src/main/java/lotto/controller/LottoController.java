package lotto.controller;

public interface LottoController {
    void purchaseLotto(int money);

    void saveWinningNumber(String winningNumber);

    void saveBonusNumber(int bonusNumber);

    void matchWinningNumber();
}
