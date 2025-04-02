package lotto.view;

import lotto.dto.LottosDTO;
import lotto.model.LottoResult;

public interface View {
    String readAmount();
    String readWinningNumbers();
    String readBonusNumber();
    void printLottoTickets(LottosDTO tickets, int count);
    void printResult(LottoResult result);
    void printProfit(double returnRate);
    void printError(String message);
}