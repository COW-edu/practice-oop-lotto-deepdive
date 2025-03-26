package lotto.domain.port.out;

import lotto.domain.model.LottoTickets;

public interface LottoRepositoryPort {
    void save(LottoTickets tickets);
    LottoTickets findAll();
}
