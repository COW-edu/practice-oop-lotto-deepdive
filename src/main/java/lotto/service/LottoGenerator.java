package lotto.service;
import lotto.model.Lotto;
import java.util.List;

public interface LottoGenerator {
    List<Lotto> generate(int count);
}
