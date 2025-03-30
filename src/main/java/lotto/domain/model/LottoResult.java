package lotto.domain.model;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> results = new EnumMap<>(LottoRank.class);

    public LottoResult(Map<LottoRank, Integer> results) {
        for (LottoRank rank : LottoRank.values()) {
            this.results.put(rank, results.getOrDefault(rank, 0));
        }
    }

    public Map<LottoRank, Integer> getResults() {
        return Collections.unmodifiableMap(results);
    }

    public int getCountByRank(LottoRank rank) {
        return results.getOrDefault(rank, 0);
    }
}
