package lotto.domain;

import java.util.*;

public class LottoMatcher {

    private final Map<LottoRank, Integer> rankCounts = new HashMap<>();

    public LottoMatcher() {
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public Map<LottoRank, Integer> getRankCount() {
        return rankCounts;
    }

    public void compareLotto(List<Lotto> lottoList, WinLotto winLotto) {
        lottoList.forEach(lotto -> updateRank(lotto, winLotto));
    }

    private void updateRank(Lotto lotto, WinLotto winLotto) {
        LottoRank rank = determineRank(lotto, winLotto);
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    private LottoRank determineRank(Lotto lotto, WinLotto winLotto) {
        int count = compareWinNumber(lotto, winLotto);
        boolean bonus = compareBonusNumber(lotto, winLotto);

        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.getMatchCount() == count)
                .findFirst()
                .map(rank -> {
                    if (rank == LottoRank.SECOND && bonus) return LottoRank.SECOND;
                    if (rank == LottoRank.SECOND) return LottoRank.THIRD;
                    return rank;
                })
                .orElse(LottoRank.NONE);
    }

    private int compareWinNumber(Lotto lotto, WinLotto winLotto) {
        List<Integer> lottoNumber = lotto.getNumbers();
        List<Integer> winLottoNumber = winLotto.getLotto();

        Set<Integer> lottoSet = new HashSet<>(lottoNumber);
        lottoSet.retainAll(winLottoNumber);

        return lottoSet.size();
    }

    private boolean compareBonusNumber(Lotto lotto, WinLotto winLotto) {
        return lotto.getNumbers().contains(winLotto.getBonus());
    }
}