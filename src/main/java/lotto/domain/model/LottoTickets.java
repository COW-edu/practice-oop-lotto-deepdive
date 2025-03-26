package lotto.domain.model;

import lotto.domain.generator.LottoNumberGenerator;
import lotto.util.ErrorMessages;
import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private static final int PRICE_PER_TICKET = 1000;

    private final List<Lotto> tickets;

    public static LottoTickets fromAmount(int amount, LottoNumberGenerator generator) {
        validateAmount(amount);
        int count = amount / PRICE_PER_TICKET;
        List<Lotto> generated = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            generated.add(new Lotto(generator.generate()));
        }
        return new LottoTickets(generated);
    }

    private LottoTickets(List<Lotto> tickets) {
        validateEmpty(tickets);
        this.tickets = List.copyOf(tickets);
    }

    private void validateEmpty(List<Lotto> tickets) {
        if (tickets == null || tickets.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_LOTTO_TICKET_LIST);
        }
    }

    private static void validateAmount(int amount) {
        if (amount <= 0 || amount % PRICE_PER_TICKET != 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PURCHASE_AMOUNT);
        }
    }

    public List<Lotto> getTickets() {
        return tickets;
    }

    public int size() {
        return tickets.size();
    }
}