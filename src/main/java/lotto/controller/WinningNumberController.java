package lotto.controller;

public interface WinningNumberController {

    void saveWinningNumber(String winningNumbers);

    void saveBonusNumber(int bonusNumber);

    float getRateOfReturn();

    int getThreeCount();

    int getFourCount();

    int getFiveCount();

    int getBonusCount();

    int getSixCount();

}
