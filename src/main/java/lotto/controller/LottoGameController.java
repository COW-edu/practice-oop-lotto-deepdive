package lotto.controller;

import lotto.dto.LottosDTO;
import lotto.model.GameResult;
import lotto.model.Ticket;
import lotto.model.WinningNumbers;
import lotto.service.LottoGameFacade;
import lotto.view.View;

public class LottoGameController {
    private final View view;
    private final LottoGameFacade gameFacade;

    public LottoGameController(View view, LottoGameFacade gameFacade) {
        this.view = view;
        this.gameFacade = gameFacade;
    }

    public void start() {
        try {
            String purchaseAmount = view.readAmount();
            LottosDTO lottos = gameFacade.purchaseAndGenerateLottos(purchaseAmount);
            Ticket ticket = new Ticket(purchaseAmount);
            view.printLottoTickets(lottos, ticket.getAmount());

            String winningNumbersInput = view.readWinningNumbers();
            String bonusNumberInput = view.readBonusNumber();

            WinningNumbers winningNumbers = gameFacade.createWinningNumbers(winningNumbersInput, bonusNumberInput);

            GameResult result = gameFacade.calculateGameResult(lottos, winningNumbers, ticket.getPrice());

            view.printResult(result.getLottoResult());
            view.printProfit(result.getReturnRate());

        } catch (Exception e) {
            view.printError(e.getMessage());
        }
    }
}