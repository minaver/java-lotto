package lotto;

import lotto.vo.WinLotto;

import java.util.List;

public class Shop {
    private LottoGenerator lottoGenerator;

    public Shop(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> getPayedLotto(int money) {

        return null;
    }

    public WinLotto getWinLotto(List<Integer> targetNumber, int bonusNumber) {
        return null;
    }

    private int getLottoCount(int money) {
        return money / Constant.moneyUnit;
    }

    private void moneySizeValidate(int money) {
        if (money < Constant.moneyUnit) {
            System.out.println(Constant.errorSmallSizeMoney);
            throw new IllegalArgumentException();
        }
        if (money % Constant.moneyUnit == 0) {
            System.out.println(Constant.errorWrongSizeMoney);
            throw new IllegalArgumentException();
        }
    }

    private void moneyTypeValidate(int money) {

    }

    private void bonusNumValidate(int bonusNumber) {

    }
}
