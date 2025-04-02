package lotto.service;

import lotto.dto.LottosDTO;
import lotto.model.Ticket;

public class LottoService {
    private final LottoGenerator lottoGenerator;

    public LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Ticket createTicket(String amount) {
        return new Ticket(amount);
    }

    public LottosDTO generateLottos(Ticket ticket) {
        return new LottosDTO(lottoGenerator.generate(ticket.getAmount()));
    }
}