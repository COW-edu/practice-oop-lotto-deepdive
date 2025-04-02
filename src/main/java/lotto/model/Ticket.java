package lotto.model;

public class Ticket {
    private final Money price;
    private final int lottoCount;

    public Ticket(String inputAmount) {
        Money money = Money.wons(inputAmount);
        money.validateLottoAmount();

        this.price = money;
        this.lottoCount = money.getLottoCount();
    }

    public int getAmount() {
        return lottoCount;
    }

    public int getPrice() {
        return price.getAmount();
    }

}