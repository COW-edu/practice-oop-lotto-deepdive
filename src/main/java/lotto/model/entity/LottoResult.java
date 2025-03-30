package lotto.model.entity;

public class LottoResult {
    private final int threeCount;
    private final int fourCount;
    private final int fiveCount;
    private final int bonusCount;
    private final int sixCount;

    public LottoResult(int threeCount, int fourCount, int fiveCount, int bonusCount, int sixCount) {
        this.threeCount = threeCount;
        this.fourCount = fourCount;
        this.fiveCount = fiveCount;
        this.bonusCount = bonusCount;
        this.sixCount = sixCount;
    }

    public int getThreeCount() { return threeCount; }
    public int getFourCount() { return fourCount; }
    public int getFiveCount() { return fiveCount; }
    public int getBonusCount() { return bonusCount; }
    public int getSixCount() { return sixCount; }
}
