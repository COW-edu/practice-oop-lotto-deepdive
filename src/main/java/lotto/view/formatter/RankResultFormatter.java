package lotto.view.formatter;

import lotto.constants.LottoRank;

import static lotto.constants.ErrorMessage.LOTTO_INSTANCE_ERROR;

public class RankResultFormatter implements Formatter {
    private final Formatter moneyFormatter;

    public RankResultFormatter(Formatter moneyFormatter) {
        this.moneyFormatter = moneyFormatter;
    }

    @Override
    public String format(Object value) {
        if (!(value instanceof LottoRank)) {
            throw new IllegalArgumentException(LOTTO_INSTANCE_ERROR.getMessage());
        }
        LottoRank rank = (LottoRank) value;
        String bonusMatchText = rank.isBonusMatch() ? ", 보너스 볼 일치" : "";
        return String.format("%d개 일치%s (%s)",
                rank.getMatchCount(),
                bonusMatchText,
                moneyFormatter.format(rank.getPrize()));
    }
}