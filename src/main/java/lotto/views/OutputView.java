package lotto.views;

import lotto.Constant;
import lotto.Lotto;
import lotto.enums.Grade;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OutputView {

    public void printPayedLotto(List<Lotto> payedLottos) {
        System.out.println(payedLottos.size()+ Constant.outputPayedLotto);
        for (Lotto lotto : payedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinStats(Map<Grade,Integer> winStats) {
        System.out.println(Constant.outputWinStatTitle);
        for (Map.Entry<Grade, Integer> entry : winStats.entrySet()) {
            String prize = convertPrizeString(String.valueOf(entry.getKey().number()));

            if (entry.getKey().equals(Grade.second)) {
                System.out.printf(Constant.outputWinStatBonus,
                        entry.getKey().correct(),prize,entry.getValue());
                return;
            }
            System.out.printf(Constant.outputWinStat,
                    entry.getKey().correct(),prize,entry.getValue());

        }
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
