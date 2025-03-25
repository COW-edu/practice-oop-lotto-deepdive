package lotto.view;

import lotto.controller.LottoCountController;
import lotto.controller.LottoNumberController;
import lotto.controller.WinningNumberController;

public class OutputViewImpl implements OutputView {

    private final LottoCountController lottoCountController;
    private final LottoNumberController lottoNumberController;
    private final WinningNumberController winningNumberController;

    public OutputViewImpl(LottoCountController lottoCountController,
            LottoNumberController lottoNumberController,
            WinningNumberController winningNumberController) {
        this.lottoCountController = lottoCountController;
        this.lottoNumberController = lottoNumberController;
        this.winningNumberController = winningNumberController;
    }

    @Override
    public void outputPurchasedLottoCount() {
        int purchasedLottoCount = lottoCountController.getPurchasedLottoCount();
        System.out.println(purchasedLottoCount + "개를 구매했습니다.");
    }

    @Override
    public void outputPurchasedLottoNumbers() {
        System.out.println(lottoNumberController.getLottoNumbers());
    }

    @Override
    public void outputWinningDetail() {
        int threeCount = winningNumberController.getThreeCount();
        int fourCount = winningNumberController.getFourCount();
        int fiveCount = winningNumberController.getFiveCount();
        int bonusCount = winningNumberController.getBonusCount();
        int sixCount = winningNumberController.getSixCount();

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
        float rateOfReturn = winningNumberController.getRateOfReturn();
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
