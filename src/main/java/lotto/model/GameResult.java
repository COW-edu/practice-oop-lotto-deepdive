package lotto.model;

public class GameResult {
    private final LottoResult lottoResult;
    private final double returnRate;

    public GameResult(LottoResult lottoResult, double returnRate) {
        this.lottoResult = lottoResult;
        this.returnRate = returnRate;
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }

    public double getReturnRate() {
        return returnRate;
    }
}