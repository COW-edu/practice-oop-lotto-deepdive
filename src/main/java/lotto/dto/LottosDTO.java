package lotto.dto;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottosDTO {
    private final List<Lotto> lottos;

    public LottosDTO(List<Lotto> numbers) {
        this.lottos = Collections.unmodifiableList(new ArrayList<>(numbers));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}