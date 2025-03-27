package lotto.config;

import lotto.controller.LottoController;
import lotto.controller.LottoControllerImpl;
import lotto.model.LottoCountRepository;
import lotto.model.LottoCountRepositoryImpl;
import lotto.model.LottoNumberRepository;
import lotto.model.LottoNumberRepositoryImpl;
import lotto.model.WinningRepository;
import lotto.model.WinningRepositoryImpl;
import lotto.service.LottoServiceImpl;
import lotto.service.FacadeLottoCountService;
import lotto.service.FacadeLottoCountServiceImpl;
import lotto.service.FacadeLottoNumberService;
import lotto.service.FacadeLottoNumberServiceImpl;
import lotto.service.LottoService;
import lotto.service.FacadeWinningService;
import lotto.service.FacadeWinningServiceImpl;

public class AppConfig {

    public LottoController lottoController() {
        return new LottoControllerImpl(lottoService());
    }

    public LottoService lottoService() {
        return new LottoServiceImpl(lottoCountService(), lottoNumberService(),
                winningNumberService());
    }

    public FacadeLottoCountService lottoCountService() {
        return new FacadeLottoCountServiceImpl(lottoCountRepository());
    }

    public FacadeLottoNumberService lottoNumberService() {
        return new FacadeLottoNumberServiceImpl(lottoNumberRepository());
    }

    public FacadeWinningService winningNumberService() {
        return new FacadeWinningServiceImpl(lottoCountRepository(), winningNumberRepository());
    }

    public LottoCountRepository lottoCountRepository() {
        return new LottoCountRepositoryImpl();
    }


    public LottoNumberRepository lottoNumberRepository() {
        return new LottoNumberRepositoryImpl();
    }

    public WinningRepository winningNumberRepository() {
        return new WinningRepositoryImpl();
    }

}
