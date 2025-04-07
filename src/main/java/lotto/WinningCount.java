package lotto;

public enum WinningCount {
    THREE_COUNT(3, 5000),
    FOUR_COUNT(4, 50000),
    FIVE_COUNT(5, 1500000),
    BONUS_COUNT(0, 3000000),
    SIX_COUNT(6, 20000000);

    private final int count;
    private final int amount;

    WinningCount(int count, int amount) {
        this.count = count;
        this.amount = amount;
    }

    public int getCount() {
        return count;
    }
    public int getAmount() {
        return amount;
    }
}
