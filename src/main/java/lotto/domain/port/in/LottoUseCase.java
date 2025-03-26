package lotto.domain.port.in;

import lotto.domain.model.LottoTickets;

public interface LottoUseCase {
    void purchase(int amount);
    LottoTickets getLottoTickets();
}
