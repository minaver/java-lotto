package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGenerator {

    public Lotto generateLotto(List<Integer> targetNumber) {
        return new Lotto(targetNumber);
    }

    public Lotto generateLottoRandom() {
        List<Integer> targetNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(targetNumber);
    }

}
