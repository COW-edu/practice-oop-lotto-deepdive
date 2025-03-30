package lotto.domain.port.in;

import lotto.application.dto.LottoResultDTO;
import lotto.domain.model.LottoTickets;
import lotto.domain.model.WinningLotto;

public interface LottoUseCase {
    void purchase(int amount);
    LottoTickets getLottoTickets();

    LottoResultDTO checkWinning(LottoTickets tickets, WinningLotto winningLotto, int amount);
}
