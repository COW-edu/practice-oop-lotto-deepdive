package lotto.view;

import static lotto.constants.OutputViewConstants.BONUS_WINNING_MESSAGE;
import static lotto.constants.OutputViewConstants.COUNT_MESSAGE;
import static lotto.constants.OutputViewConstants.FIVE_WINNING_MESSAGE;
import static lotto.constants.OutputViewConstants.FOUR_WINNING_MESSAGE;
import static lotto.constants.OutputViewConstants.LINE_MESSAGE;
import static lotto.constants.OutputViewConstants.OUTPUT_LOTTO_COUNT_MESSAGE;
import static lotto.constants.OutputViewConstants.PERCENT_MESSAGE;
import static lotto.constants.OutputViewConstants.RATE_OF_RETURN_MESSAGE;
import static lotto.constants.OutputViewConstants.SIX_WINNING_MESSAGE;
import static lotto.constants.OutputViewConstants.THREE_WINNING_MESSAGE;
import static lotto.constants.OutputViewConstants.WINNING_STATISTICS_MESSAGE;

import java.util.List;
import lotto.controller.LottoController;

public class OutputViewImpl implements OutputView {
    private final LottoController lottoController;

    public OutputViewImpl(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    @Override
    public void outputPurchasedLottoCount() {
        int purchasedLottoCount = lottoController.getPurchasedLottoCount();
        System.out.println();
        System.out.println(purchasedLottoCount + OUTPUT_LOTTO_COUNT_MESSAGE);
    }

    @Override
    public void outputPurchasedLottoNumbers() {
        List<List<Integer>> lottoList = lottoController.getLottoList();
        for (List<Integer> lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    @Override
    public void outputWinningDetail() {
        lottoController.matchWinningNumber();

        int threeCount = lottoController.getThreeCount();
        int fourCount = lottoController.getFourCount();
        int fiveCount = lottoController.getFiveCount();
        int bonusCount = lottoController.getBonusCount();
        int sixCount = lottoController.getSixCount();

        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(LINE_MESSAGE);
        System.out.println(THREE_WINNING_MESSAGE + threeCount + COUNT_MESSAGE);
        System.out.println(FOUR_WINNING_MESSAGE + fourCount + COUNT_MESSAGE);
        System.out.println(FIVE_WINNING_MESSAGE + fiveCount + COUNT_MESSAGE);
        System.out.println(BONUS_WINNING_MESSAGE + bonusCount + COUNT_MESSAGE);
        System.out.println(SIX_WINNING_MESSAGE + sixCount + COUNT_MESSAGE);
    }

    @Override
    public void outputRateOfReturn() {
        double rateOfReturn = lottoController.getRateOfReturn();
        System.out.println(RATE_OF_RETURN_MESSAGE + rateOfReturn + PERCENT_MESSAGE);
    }
}
