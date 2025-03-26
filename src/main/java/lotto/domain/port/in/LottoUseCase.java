package lotto.domain.port.in;

import lotto.domain.model.LottoTickets;

public interface LottoUseCase {
    LottoTickets purchase(int amount);
}
