package lotto.domain.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ResultCalculator {
    public LottoResult calculate(LottoTickets tickets, WinningLotto winningLotto) {
        Map<LottoRank, Integer> resultMap = new EnumMap<>(LottoRank.class);

        for (Lotto ticket : tickets.getTickets()) {
            int matchCount = countMatchingNumbers(ticket.getNumbers(), winningLotto.getWinningNumbers());
            boolean bonusMatch = ticket.getNumbers().contains(winningLotto.getBonusNumber());

            LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch); // 등수 계산
            resultMap.put(rank, resultMap.getOrDefault(rank, 0) + 1);   // 등수별 누적 카운트
        }

        return new LottoResult(resultMap);
    }

    private int countMatchingNumbers(List<Integer> userNumbers, List<Integer> winningNumbers) {
        return (int) userNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
