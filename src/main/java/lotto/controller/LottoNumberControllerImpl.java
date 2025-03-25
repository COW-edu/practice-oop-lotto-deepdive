package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.Lotto;
import lotto.model.LottoNumberRepository;

public class LottoNumberControllerImpl implements LottoNumberController {

    private final LottoNumberRepository lottoNumberRepository;

    public LottoNumberControllerImpl(LottoNumberRepository lottoNumberRepository) {
        this.lottoNumberRepository = lottoNumberRepository;
    }

    @Override
    public void extractLottoNumbers(int purchasedCount) {
        for (int i = 0; i < purchasedCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumberRepository.saveLotto(new Lotto(lottoNumbers));
        }
    }

    @Override
    public String getLottoNumbers() {
        return lottoNumberRepository.getLottoList().toString();
    }
}
