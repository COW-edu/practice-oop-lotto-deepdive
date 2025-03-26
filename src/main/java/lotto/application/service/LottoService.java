package lotto.application.service;


import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.model.LottoTickets;
import lotto.domain.port.in.LottoUseCase;
import lotto.domain.port.out.LottoRepositoryPort;

public class LottoService implements LottoUseCase {

    private final LottoRepositoryPort repository;
    private final LottoNumberGenerator generator;

    public LottoService(LottoRepositoryPort repository, LottoNumberGenerator generator) {
        this.repository = repository;
        this.generator = generator;
    }

    @Override
    public LottoTickets purchase(int amount) {
        LottoTickets tickets = LottoTickets.fromAmount(amount, generator);
        repository.save(tickets);
        return tickets;
    }
}
