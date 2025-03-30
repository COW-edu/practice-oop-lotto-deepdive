package lotto.config;

import lotto.adapter.in.console.ConsoleInputView;
import lotto.adapter.in.console.ConsoleLottoController;
import lotto.adapter.in.console.ConsoleOutputView;
import lotto.adapter.out.memory.LottoRepository;
import lotto.application.service.LottoService;
import lotto.application.validation.*;
import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.generator.LottoNumberGeneratorImpl;
import lotto.domain.model.ResultCalculator;
import lotto.domain.port.in.LottoUseCase;
import lotto.domain.port.out.LottoRepositoryPort;

public class AppConfig {

    public ConsoleInputView consoleInputView() {
        return new ConsoleInputView();
    }

    public ConsoleOutputView consoleOutputView() {
        return new ConsoleOutputView();
    }

    public NumberValidation<String> amountValidator() {
        return new AmountValidator();
    }

    public NumberValidation<String> bonusNumberValidator() {
        return new BonusNumberValidator();
    }

    public NumberListValidation<String> lottoNumberValidator() {
        return new LottoNumberValidator();
    }

    public LottoRepositoryPort lottoRepository() {
        return new LottoRepository();
    }

    public LottoNumberGenerator lottoNumberGenerator() {
        return new LottoNumberGeneratorImpl();
    }

    public ResultCalculator resultCalculator() {
        return new ResultCalculator();
    }

    public LottoUseCase lottoUseCase() {
        return new LottoService(lottoRepository(), lottoNumberGenerator(), resultCalculator());
    }

    public ConsoleLottoController consoleLottoController() {
        return new ConsoleLottoController(
            consoleInputView(),
            consoleOutputView(),
            lottoUseCase(),
            amountValidator(),
            lottoNumberValidator(),
            bonusNumberValidator()
        );
    }
}
