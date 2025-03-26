package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.entity.Lotto;
import lotto.model.LottoCountRepository;
import lotto.model.LottoNumberRepository;

public class LottoNumberServiceImpl implements LottoNumberService {

    private final LottoNumberRepository lottoNumberRepository;

    public LottoNumberServiceImpl(LottoNumberRepository lottoNumberRepository) {
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
