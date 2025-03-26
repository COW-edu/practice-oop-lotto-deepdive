package lotto.config;

import lotto.controller.LottoController;
import lotto.controller.LottoControllerImpl;
import lotto.model.LottoCountRepository;
import lotto.model.LottoCountRepositoryImpl;
import lotto.model.LottoNumberRepository;
import lotto.model.LottoNumberRepositoryImpl;
import lotto.model.WinningNumberRepository;
import lotto.model.WinningNumberRepositoryImpl;
import lotto.service.LottoCountService;
import lotto.service.LottoCountServiceImpl;
import lotto.service.LottoNumberService;
import lotto.service.LottoNumberServiceImpl;
import lotto.service.WinningNumberService;
import lotto.service.WinningNumberServiceImpl;

public class AppConfig {

    public LottoController lottoController() {
        return new LottoControllerImpl(lottoCountService(), lottoNumberService(),
                winningNumberService());
    }

    public LottoCountService lottoCountService() {
        return new LottoCountServiceImpl(lottoCountRepository());
    }

    public LottoNumberService lottoNumberService() {
        return new LottoNumberServiceImpl(lottoNumberRepository());
    }

    public WinningNumberService winningNumberService() {
        return new WinningNumberServiceImpl(winningNumberRepository());
    }

    public LottoCountRepository lottoCountRepository() {
        return new LottoCountRepositoryImpl();
    }


    public LottoNumberRepository lottoNumberRepository() {
        return new LottoNumberRepositoryImpl();
    }

    public WinningNumberRepository winningNumberRepository() {
        return new WinningNumberRepositoryImpl();
    }

}
