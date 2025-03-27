package lotto;

public enum WinningCount {
    THREE_COUNT(3),
    FOUR_COUNT(4),
    FIVE_COUNT(5),
    BONUS_COUNT(0),
    SIX_COUNT(6);

    private final int count;

    WinningCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
