package lotto;

import lotto.enums.Grade;
import lotto.vo.WinLotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoCompany {
    private WinLotto winLottoInfo;
    private Map<Grade,Integer> winStats;

    public LottoCompany(WinLotto winLottoInfo) {
        this.winLottoInfo = winLottoInfo;
        initWinStats();
    }

    public Map<Grade,Integer> getWinStats(List<Lotto> payedLottos) {
        Grade grade;
        for (Lotto payedLotto : payedLottos) {
            grade = chooseGrade(compareToWinLotto(payedLotto),compareBonusNumber(payedLotto));
            winStats.put(grade,winStats.get(grade)+1);
        }
        return winStats;
    }

    public Double getEarningRate(int money, Map<Grade,Integer> winStats) {
        int earningMoney = calcTotalEarningMoney(winStats);
        return calcEarningRate(money, earningMoney);
    }

    private void initWinStats() {
        winStats.put(Grade.first,0);
        winStats.put(Grade.second,0);
        winStats.put(Grade.third,0);
        winStats.put(Grade.forth,0);
        winStats.put(Grade.fifth,0);
        winStats.put(Grade.none,0);
    }

    private int compareToWinLotto(Lotto lotto) {
        int count = 0;
        Lotto winLotto = winLottoInfo.getWinLotto();
        for (int i = 0; i < Constant.lottoSize; i++) {
            if (winLotto.getNumbers().get(i).equals(lotto.getNumbers().get(i))) {
                count++;
            }
        }
        return count;
    }

    private boolean compareBonusNumber(Lotto lotto) {
        for (int number : lotto.getNumbers()) {
            if (number == winLottoInfo.getBonusNumber()) {
                return true;
            }
        }
        return false;
    }

    private Grade chooseGrade(int count, boolean isBonus) {
        if (count == Constant.firstCorrectNum) {
            return Grade.first;
        } else if (count == Constant.forthCorrectNum) {
            return Grade.forth;
        } else if (count == Constant.fifthCorrectNum) {
            return Grade.fifth;
        } else if (count == Constant.thirdCorrectNum) {
            return chooseSecondThirdGrade(isBonus);
        }
        return Grade.none;
    }

    private Grade chooseSecondThirdGrade(boolean isBonus) {
        if (isBonus == true) {
            return Grade.second;
        }
        return Grade.third;
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
