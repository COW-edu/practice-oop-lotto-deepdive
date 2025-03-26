package lotto.config;

import lotto.adapter.in.console.ConsoleInputView;
import lotto.adapter.in.console.ConsoleLottoController;
import lotto.adapter.in.console.ConsoleOutputView;
import lotto.adapter.out.memory.LottoRepository;
import lotto.application.service.LottoService;
import lotto.application.validation.AmountValidator;
import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.generator.LottoNumberGeneratorImpl;
import lotto.domain.port.in.LottoUseCase;
import lotto.domain.port.out.LottoRepositoryPort;
import lotto.application.validation.Validation;

public class AppConfig {

    public ConsoleInputView consoleInputView() {
        return new ConsoleInputView();
    }

    public ConsoleOutputView consoleOutputView() {
        return new ConsoleOutputView();
    }

    public Validation<String> amountValidator() {
        return new AmountValidator();
    }

    public LottoRepositoryPort lottoRepository() {
        return new LottoRepository();
    }

    public LottoNumberGenerator lottoNumberGenerator() {
        return new LottoNumberGeneratorImpl();
    }

    public LottoUseCase lottoUseCase() {
        return new LottoService(lottoRepository(), lottoNumberGenerator());
    }

    public ConsoleLottoController consoleLottoController() {
        return new ConsoleLottoController(
            consoleInputView(),
            consoleOutputView(),
            lottoUseCase(),
            amountValidator()
        );
    }
}
