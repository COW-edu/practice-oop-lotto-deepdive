package lotto.constants;

public enum LottoRank {
    FIRST(1, 6, false, 2_000_000_000),
    SECOND(2, 5, true, 30_000_000),
    THIRD(3, 5, false, 1_500_000),
    FOURTH(4, 4, false, 50_000),
    FIFTH(5, 3, false, 5_000),
    NONE(6, 0, false, 0);

    private final int rank;
    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;

    LottoRank(int rank, int matchCount, boolean bonusMatch, int prize) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public static LottoRank from(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && bonusMatch) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

}