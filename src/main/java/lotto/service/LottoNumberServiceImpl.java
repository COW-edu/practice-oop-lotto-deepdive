package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.Lotto;
import lotto.model.LottoCountRepository;
import lotto.model.LottoNumberRepository;

public class LottoNumberServiceImpl implements LottoNumberService {

    private final LottoCountRepository lottoCountRepository;
    private final LottoNumberRepository lottoNumberRepository;

    public LottoNumberServiceImpl(LottoCountRepository lottoCountRepository, LottoNumberRepository lottoNumberRepository) {
        this.lottoCountRepository = lottoCountRepository;
        this.lottoNumberRepository = lottoNumberRepository;
    }

    @Override
    public void extractLottoNumbers() {
        int purchasedCount = lottoCountRepository.getLottoCount();
        for (int i = 0; i < purchasedCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumberRepository.saveLotto(new Lotto(lottoNumbers));
        }
    }

    @Override
    public List<Lotto> getLottoList() {
        return lottoNumberRepository.getLottoList();
    }

}
