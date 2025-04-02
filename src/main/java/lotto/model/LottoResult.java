package lotto.model;

import lotto.constants.LottoRank;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCounts;

    public LottoResult() {
        this.rankCounts = new EnumMap<>(LottoRank.class);
        initializeRankCounts();
    }

    public void addRank(LottoRank rank) {
        if (rankCounts.containsKey(rank)) {
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }
    }

    public int getCount(LottoRank rank) {
        return rankCounts.getOrDefault(rank, 0);
    }

    private long calculateTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
    public double calculateReturnRate(int purchaseAmount) {
        if (purchaseAmount == 0) {
            return 0.0;
        }
        return (double) calculateTotalPrize() / purchaseAmount * 100;
    }

    private void initializeRankCounts() {
        getValidRanks().forEach(rank -> rankCounts.put(rank, 0));
    }

    private java.util.List<LottoRank> getValidRanks() {
        return Arrays.stream(LottoRank.values())
                .filter(this::isValidRank)
                .collect(Collectors.toList());
    }

    private boolean isValidRank(LottoRank rank) {
        return rank != LottoRank.NONE;
    }
}