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

    public Controller() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.shop = new Shop(new LottoGenerator());
    }

    public List<Lotto> getLottos() throws Exception {
        payedMoney = inputView.getPayedMoney();
        List<Lotto> payedLotto = shop.getPayedLotto(payedMoney);
        outputView.printPayedLotto(payedLotto);
        return payedLotto;
    }

    public void setWinLotto() throws Exception {
        List<Integer> winLottoNumber = inputView.getWinLottoNumber();
        int bonusNumber = inputView.getBonusNumber();
        WinLotto winLotto = shop.getWinLotto(winLottoNumber, bonusNumber);
        lottoCompany = new LottoCompany(winLotto);
    }

    public void getStats(List<Lotto> payedLottos) throws Exception {
        Map<Grade, Integer> winStats = lottoCompany.getWinStats(payedLottos);
        Double earningRate = lottoCompany.getEarningRate(payedMoney, winStats);
        outputView.printWinStats(winStats);
        outputView.printEarningRate(earningRate);
    }

}
