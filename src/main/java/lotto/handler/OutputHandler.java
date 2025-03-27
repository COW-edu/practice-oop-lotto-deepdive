package lotto.handler;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.List;
import java.util.Map;

import static lotto.common.Constant.*;


public class OutputHandler {

    public void printPurchaseCount(int count) {
        System.out.println(count + PURCHASE_MESSAGE);
    }

    public void printAllLottoNumber(List<Lotto> lottoList) {
        lottoList.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public void printResult(Map<LottoRank, Integer> rankCount, double record) {
        System.out.printf(RESULT_FORMAT,
                rankCount.getOrDefault(LottoRank.FIFTH, 0),
                rankCount.getOrDefault(LottoRank.FORTH, 0),
                rankCount.getOrDefault(LottoRank.THIRD, 0),
                rankCount.getOrDefault(LottoRank.SECOND, 0),
                rankCount.getOrDefault(LottoRank.FIRST, 0),
                record);
    }

    public void printException(String message) {
        System.out.println(ERROR + message);
    }
}
