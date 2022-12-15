package lotto;

import lotto.enums.Grade;
import lotto.views.InputView;
import lotto.views.OutputView;
import lotto.vo.WinLotto;

import java.util.List;
import java.util.Map;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final Shop shop;
    private LottoCompany lottoCompany;
    private int payedMoney;

    public Controller(InputView inputView, OutputView outputView, Shop shop) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.shop = shop;
    }

    public List<Lotto> getLottos() {
        payedMoney = inputView.getPayedMoney();
        List<Lotto> payedLotto = shop.getPayedLotto(payedMoney);
        outputView.printPayedLotto(payedLotto);
        return payedLotto;
    }

    public void setWinLotto() {
        List<Integer> winLottoNumber = inputView.getWinLottoNumber();
        int bonusNumber = inputView.getBonusNumber();
        WinLotto winLotto = shop.getWinLotto(winLottoNumber, bonusNumber);
        lottoCompany = new LottoCompany(winLotto);
    }

    public void getStats(List<Lotto> payedLottos) {
        Map<Grade, Integer> winStats = lottoCompany.getWinStats(payedLottos);
        lottoCompany.getEarningRate(payedMoney,winStats);
    }

}
