package lotto.views;

import lotto.Constant;
import lotto.Lotto;
import lotto.enums.Grade;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {

    public void printPayedLotto(List<Lotto> payedLottos) {
        System.out.println(payedLottos.size()+ Constant.outputPayedLotto);
        for (Lotto lotto : payedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinStats(Map<Grade,Integer> winStats) {
        System.out.println(Constant.outputWinStatTitle);
        System.out.printf(Constant.outputWinStat,
                Grade.fifth.correct(),convertPrizeString(String.valueOf(Grade.fifth.number())), winStats.get(Grade.first),
                Grade.forth.correct(),convertPrizeString(String.valueOf(Grade.forth.number())), winStats.get(Grade.forth),
                Grade.third.correct(),convertPrizeString(String.valueOf(Grade.third.number())), winStats.get(Grade.third),
                Grade.second.correct(),convertPrizeString(String.valueOf(Grade.second.number())), winStats.get(Grade.second),
                Grade.first.correct(),convertPrizeString(String.valueOf(Grade.first.number())), winStats.get(Grade.first));
    }

    public void printEarningRate(Double earningRate) {
        System.out.print(Constant.outputTotalEarningRateStart + earningRate
                + Constant.outputTotalEarningRateEnd);
    }

    private String convertPrizeString(String prize) {
        StringBuffer sb = new StringBuffer();
        sb.append(prize);
        for (int i = prize.length()-3; i > 0; i = i-3) {
            sb.insert(i,",");
        }
        return sb.toString();
    }
}
