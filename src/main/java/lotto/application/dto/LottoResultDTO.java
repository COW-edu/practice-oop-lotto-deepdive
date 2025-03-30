package lotto.application.dto;

import lotto.domain.model.LottoResult;

public class LottoResultDTO {
    private final LottoResult result;
    private final double profitRate;

    public LottoResultDTO(LottoResult result, double profitRate) {
        this.result = result;
        this.profitRate = profitRate;
    }

    public LottoResult getResult() {
        return result;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
