package lotto.adapter.in.console;

import lotto.domain.model.Lotto;
import lotto.domain.model.LottoRank;
import lotto.domain.model.LottoResult;
import lotto.domain.model.LottoTickets;
import lotto.util.LottoFormatter;

import java.util.Arrays;
import java.util.List;

public class ConsoleOutputView {
    private static final String PURCHASED_TICKETS_MESSAGE = "\n%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_TITLE = "\n당첨 통계";
    private static final String SEPARATOR_LINE = "---";

    public void printLottoTickets(LottoTickets lootoTickets){
        System.out.printf((PURCHASED_TICKETS_MESSAGE) + "%n", lootoTickets.size());
        List<Lotto> tickets = lootoTickets.getTickets();
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public void printStatistics(LottoResult result, double profitRate) {
        System.out.println(WINNING_STATISTICS_TITLE);
        System.out.println(SEPARATOR_LINE);

        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NONE)
                .forEach(rank -> {
                    String rankResult = LottoFormatter.formatRankResult(rank, result.getCountByRank(rank));
                    System.out.println(rankResult);
                });

        String formattedProfitRate = LottoFormatter.formatProfitRate(profitRate);
        System.out.println(formattedProfitRate);
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
