package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.LottoRank;
import lotto.dto.LottosDTO;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.view.formatter.Formatter;

public class ConsoleView implements View {

    private static final String INPUT_PRICE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String OUTPUT_STATIC_START = "당첨 통계\n---";
    private static final String RANK_FORMAT = "%s - %d개";
    private static final String PROFIT_MESSAGE = "총 수익률은 %s입니다.";
    private static final String ERROR_PREFIX = "[ERROR] ";

    private final Formatter rateFormatter;
    private final Formatter rankFormatter;

    public ConsoleView(Formatter rateFormatter, Formatter rankFormatter) {
        this.rateFormatter = rateFormatter;
        this.rankFormatter = rankFormatter;
    }

    @Override
    public String readAmount() {
        System.out.println(INPUT_PRICE);
        return Console.readLine();
    }

    @Override
    public String readWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    @Override
    public String readBonusNumber() {
        System.out.println(INPUT_BONUS);
        return Console.readLine();
    }

    @Override
    public void printLottoTickets(LottosDTO tickets, int count) {
        System.out.println(count + LOTTO_COUNT_MESSAGE);
        for (Lotto ticket : tickets.getLottos()) {
            System.out.println(ticket.getNumbers());
        }
    }

    @Override
    public void printResult(LottoResult result) {
        System.out.println(OUTPUT_STATIC_START);

        LottoRank[] ranks = {LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD,
                LottoRank.SECOND, LottoRank.FIRST};

        for (LottoRank rank : ranks) {
            printRankResult(result, rank);
        }
    }

    private void printRankResult(LottoResult result, LottoRank rank) {
        String resultText = String.format(
                RANK_FORMAT,
                rankFormatter.format(rank),
                result.getCount(rank)
        );

        System.out.println(resultText);
    }

    @Override
    public void printProfit(double returnRate) {
        System.out.println(String.format(PROFIT_MESSAGE, rateFormatter.format(returnRate)));
    }

    @Override
    public void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}