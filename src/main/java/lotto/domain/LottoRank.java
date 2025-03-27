package lotto.domain;

public enum LottoRank {

    FIRST(6, 2000000000, "6개 일치"),
    SECOND(5, 30000000, "5개 일치"),
    THIRD(5, 1500000, "5개 일치"),
    FORTH(4, 1500000, "4개 일치"),
    FIFTH(3,  5000, "3개 일치"),
    NONE(0, 0, "0개 일치");

    public final int matchCount;
    public final int reward;
    public final String description;

    LottoRank(int matchCount, int reward, String description) {
        this.matchCount = matchCount;
        this.reward= reward;
        this.description = description;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
