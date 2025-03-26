package lotto.adapter.in.console;

import lotto.application.validation.Validation;
import lotto.domain.model.LottoTickets;
import lotto.domain.port.in.LottoUseCase;

public class ConsoleLottoController {
    private final ConsoleInputView inputView;
    private final ConsoleOutputView outputView;
    private final LottoUseCase lottoUseCase;
    private final Validation<String> amountValidator;

    public ConsoleLottoController(ConsoleInputView inputView, ConsoleOutputView outputView, LottoUseCase lottoUseCase, Validation<String> amountValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoUseCase = lottoUseCase;
        this.amountValidator = amountValidator;
    }

    public void run() {
        try {
            int amount = amountValidator.validate(inputView.inputPurchaseAmount());
            lottoUseCase.purchase(amount);
            LottoTickets tickets = lottoUseCase.getLottoTickets();
            outputView.printLottoTickets(tickets);
        }catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
        }
    }
}
