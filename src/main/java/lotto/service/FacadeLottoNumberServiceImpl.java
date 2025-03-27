package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.model.entity.Lotto;
import lotto.model.LottoNumberRepository;

public class FacadeLottoNumberServiceImpl implements FacadeLottoNumberService {

    private final LottoNumberRepository lottoNumberRepository;

    public FacadeLottoNumberServiceImpl(LottoNumberRepository lottoNumberRepository) {
        this.lottoNumberRepository = lottoNumberRepository;
    }

    @Override
    public void extractLottoNumbers(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumbers);
            lottoNumberRepository.saveLotto(new Lotto(lottoNumbers));
        }
    }

    @Override
    public List<Lotto> getLottoList() {
        return lottoNumberRepository.getLottoList();
    }

}
