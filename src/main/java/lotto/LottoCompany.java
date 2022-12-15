package lotto;

import lotto.enums.Grade;
import lotto.vo.WinLotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoCompany {
    private WinLotto winLotto;

    public LottoCompany(WinLotto winLotto) {
        this.winLotto = winLotto;
    }

    public Map<Grade,Integer> getWinStats(List<Lotto> payedLotto) {
        return null;
    }

    public Double getEarningRate(int money, Map<Grade,Integer> winStats) {
        return null;
    }

    private int calcTotalEarningMoney(Map<Grade,Integer> winStats) {
        winStats.entrySet().stream()
                .filter(v -> v.getValue() != 0)
                .collect(Collectors.summingInt(v -> v.getKey().number()));
        return 0;
    }

    private Double calcEarningRate(int money, int earningMoney) {
        return Math.round((earningMoney/(double)money) * 10000)/100.0;
    }
}
