package lotto.service;

import lotto.dto.LottosDTO;
import lotto.model.GameResult;
import lotto.model.LottoResult;
import lotto.model.Ticket;
import lotto.model.WinningNumbers;

public class LottoGameFacade {
    private final LottoService lottoService;
    private final WinningNumbersService winningNumbersService;
    private final ResultService resultService;

    public LottoGameFacade(
            LottoService lottoService,
            WinningNumbersService winningNumbersService,
            ResultService resultService) {
        this.lottoService = lottoService;
        this.winningNumbersService = winningNumbersService;
        this.resultService = resultService;
    }

    public LottosDTO purchaseAndGenerateLottos(String purchaseAmount) {
        Ticket ticket = lottoService.createTicket(purchaseAmount);
        return lottoService.generateLottos(ticket);
    }

    public WinningNumbers createWinningNumbers(String winningNumbersInput, String bonusNumberInput) {
        return winningNumbersService.createWinningNumbers(winningNumbersInput, bonusNumberInput);
    }

    public GameResult calculateGameResult(LottosDTO lottos, WinningNumbers winningNumbers, int purchaseAmount) {
        LottoResult lottoResult = resultService.calculateResult(lottos, winningNumbers);
        double returnRate = lottoResult.calculateReturnRate(purchaseAmount);
        return new GameResult(lottoResult, returnRate);
    }
}