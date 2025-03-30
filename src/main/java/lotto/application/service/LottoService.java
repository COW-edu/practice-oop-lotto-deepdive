package lotto.application.service;


import lotto.application.dto.LottoResultDTO;
import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.model.*;
import lotto.domain.port.in.LottoUseCase;
import lotto.domain.port.out.LottoRepositoryPort;

public class LottoService implements LottoUseCase {

    private final LottoRepositoryPort repository;
    private final LottoNumberGenerator generator;
    private final ResultCalculator resultCalculator;

    public LottoService(LottoRepositoryPort repository, LottoNumberGenerator generator, ResultCalculator resultCalculator) {
        this.repository = repository;
        this.generator = generator;
        this.resultCalculator = resultCalculator;
    }

    @Override
    public void purchase(int amount) {
        LottoTickets tickets = LottoTickets.fromAmount(amount, generator);
        repository.save(tickets);
    }

    @Override
    public LottoTickets getLottoTickets() {
        return repository.findAll();
    }

    @Override
    public LottoResultDTO checkWinning(LottoTickets tickets, WinningLotto winningLotto, int amount) {
        LottoResult result = resultCalculator.calculate(tickets, winningLotto);
        double profitRate = ProfitCalculator.calculateProfitRate(result.getResults(), amount);
        return new LottoResultDTO(result, profitRate);
    }

}
