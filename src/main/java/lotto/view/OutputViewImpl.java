package lotto.view;

import java.util.List;
import lotto.controller.LottoController;
import lotto.entity.Lotto;

public class OutputViewImpl implements OutputView {

    private final LottoController lottoController;

    public OutputViewImpl(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    @Override
    public void outputPurchasedLottoCount() {

        int purchasedLottoCount = lottoController.getPurchasedLottoCount();
        System.out.println("\n" + purchasedLottoCount + "개를 구매했습니다.");
    }

    @Override
    public void outputPurchasedLottoNumbers() {
        List<List<Integer>> lottoList = lottoController.getLottoList();
        for (List<Integer> lotto : lottoList) {
            System.out.println(lotto);
        }
        System.out.println("\n");
    }

    @Override
    public void outputWinningDetail() {
        int threeCount = lottoController.getThreeCount();
        int fourCount = lottoController.getFourCount();
        int fiveCount = lottoController.getFiveCount();
        int bonusCount = lottoController.getBonusCount();
        int sixCount = lottoController.getSixCount();

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + threeCount + "개");
        System.out.println("4개 일치 (50,000원) - " + fourCount + "개");
        System.out.println("5개 일치 (1,500,000원) - " + fiveCount + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + bonusCount + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + sixCount + "개");
    }

    @Override
    public void outputRateOfReturn() {
        float rateOfReturn = lottoController.getRateOfReturn();
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
