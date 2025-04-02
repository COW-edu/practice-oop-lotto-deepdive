package lotto;

import lotto.controller.LottoGameController;
import lotto.service.*;
import lotto.view.ConsoleView;
import lotto.view.View;
import lotto.view.formatter.*;


public class Application {
    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new RandomLottoGenerator();
        LottoService lottoService = new LottoService(lottoGenerator);
        WinningNumbersService winningNumbersService = new WinningNumbersService();
        ResultService resultService = new ResultService();

        LottoGameFacade gameFacade = new LottoGameFacade(
                lottoService,
                winningNumbersService,
                resultService);

        Formatter moneyFormatter = new MoneyFormatter();
        Formatter rateFormatter = new RateFormatter();
        Formatter rankFormatter = new RankResultFormatter(moneyFormatter);

        View view = new ConsoleView(rateFormatter, rankFormatter);


        LottoGameController controller = new LottoGameController(
                view,
                gameFacade);

        controller.start();
    }
}
