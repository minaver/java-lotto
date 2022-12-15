package lotto.vo;

import lotto.Lotto;

public class WinLotto {
    private Lotto winLotto;
    private int bonusNumber;

    public WinLotto(Lotto winLotto, int bonusNumber) {
        this.winLotto = winLotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinLotto() {
        return winLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
