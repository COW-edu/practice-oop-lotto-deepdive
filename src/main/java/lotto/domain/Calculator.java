package lotto.domain;

import java.util.Map;

import static lotto.common.Constant.PERCENTAGE_MULTIPLIER;
import static lotto.common.Constant.TICKET_PRICE;

public class Calculator {

    private double record;

    public void getRateOfReturn(Map<LottoRank, Integer> rankCount) {
        int count = rankCount.values().stream()
                .mapToInt(i -> i)
                .sum();

        int profit = rankCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().reward * entry.getValue())
                .sum();

        int totalInvestment = TICKET_PRICE * count;

        record = (double) profit / totalInvestment * PERCENTAGE_MULTIPLIER;
    }

    public double getRecord() {
        return record;
    }
}
