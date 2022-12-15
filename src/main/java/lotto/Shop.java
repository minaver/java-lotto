package lotto;

import lotto.vo.WinLotto;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private LottoGenerator lottoGenerator;

    public Shop(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> getPayedLotto(int money) {
        moneySizeValidate(money);
        return getRandomLottos(getLottoCount(money));
    }

    public WinLotto getWinLotto(List<Integer> targetNumber, int bonusNumber) {
        bonusNumValidate(bonusNumber);
        Lotto winLotto = lottoGenerator.generateLotto(targetNumber);
        return new WinLotto(winLotto,bonusNumber);
    }


    private List<Lotto> getRandomLottos(int count) {
        List<Lotto> payedLottos = new ArrayList<>();
        for (int i = 0; i < count ; i++) {
            payedLottos.add(lottoGenerator.generateLottoRandom());
        }
        return payedLottos;
    }

    private int getLottoCount(int money) {
        return money / Constant.moneyUnit;
    }

    private void moneySizeValidate(int money) {
        if (money < Constant.moneyUnit) {
            System.out.println(Constant.errorSmallSizeMoney);
            throw new IllegalArgumentException();
        }
        if (money % Constant.moneyUnit != 0) {
            System.out.println(Constant.errorWrongSizeMoney);
            throw new IllegalArgumentException();
        }
    }

    private void bonusNumValidate(int bonusNumber) {
        if (bonusNumber < Constant.lottoNumRangeStart
                || bonusNumber > Constant.lottoNumRangeEnd) {
            System.out.println(Constant.errorWrongBonusNum);
            throw new IllegalArgumentException();
        }
    }
}
