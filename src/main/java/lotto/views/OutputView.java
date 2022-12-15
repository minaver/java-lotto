package lotto.views;

import lotto.Constant;
import lotto.Lotto;
import lotto.enums.Grade;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printPayedLotto(List<Lotto> payedLottos) {
        System.out.println(payedLottos.size()+ Constant.outputPayedLotto);
        for (Lotto lotto : payedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinStats(Map<Grade,Integer> winStats) {

    }

    public void printEarningRate(Double earningRate) {

    }
}
