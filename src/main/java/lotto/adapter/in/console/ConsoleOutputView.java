package lotto.adapter.in.console;

import lotto.domain.model.Lotto;
import lotto.domain.model.LottoTickets;

import java.util.List;

public class ConsoleOutputView {
    private static final String PURCHASED_TICKETS_MESSAGE = "\n%d개를 구매했습니다.";

    public void printLottoTickets(LottoTickets lootoTickets){
        System.out.printf((PURCHASED_TICKETS_MESSAGE) + "%n", lootoTickets.size());
        List<Lotto> tickets = lootoTickets.getTickets();
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
