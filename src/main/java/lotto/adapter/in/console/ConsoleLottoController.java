package lotto.adapter.in.console;

import lotto.application.dto.LottoResultDTO;
import lotto.application.validation.NumberListValidation;
import lotto.application.validation.NumberValidation;
import lotto.domain.model.LottoTickets;
import lotto.domain.model.WinningLotto;
import lotto.domain.port.in.LottoUseCase;

import java.util.List;

public class ConsoleLottoController {
    private final ConsoleInputView inputView;
    private final ConsoleOutputView outputView;
    private final LottoUseCase lottoUseCase;
    private final NumberValidation<String> amountValidator;
    private final NumberListValidation<String> numberListValidator;
    private final NumberValidation<String> bonusValidator;

    public ConsoleLottoController(ConsoleInputView inputView, ConsoleOutputView outputView, LottoUseCase lottoUseCase, NumberValidation<String> amountValidator, NumberListValidation<String> numberListValidator, NumberValidation<String> bonusValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoUseCase = lottoUseCase;
        this.amountValidator = amountValidator;
        this.numberListValidator = numberListValidator;
        this.bonusValidator = bonusValidator;
    }

    public void run() {
        try {
            int amount = amountValidator.validate(inputView.inputPurchaseAmount());
            lottoUseCase.purchase(amount);
            LottoTickets tickets = lottoUseCase.getLottoTickets();
            outputView.printLottoTickets(tickets);

            List<Integer> winningNumbers = numberListValidator.validate(inputView.inputWinningNumbers());
            int bonusNumber = bonusValidator.validate(inputView.inputBonusNumber());
            WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

            LottoResultDTO resultDTO = lottoUseCase.checkWinning(tickets, winningLotto, amount);
            outputView.printStatistics(resultDTO.getResult(), resultDTO.getProfitRate());

        }catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
        }
    }
}
