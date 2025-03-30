package lotto.adapter.out.memory;

import lotto.domain.model.LottoTickets;
import lotto.domain.port.out.LottoRepositoryPort;

public class LottoRepository implements LottoRepositoryPort {
    private LottoTickets tickets;

    @Override
    public void save(LottoTickets tickets) {
        this.tickets = tickets;
    }

    @Override
    public LottoTickets findAll() {
        return tickets;
    }
}
