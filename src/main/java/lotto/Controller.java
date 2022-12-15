package lotto;

import lotto.views.InputView;
import lotto.views.OutputView;
import lotto.vo.WinLotto;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final Shop shop;
    private final LottoCompany lottoCompany;
    private List<Lotto> payedLottos;
    private WinLotto winLotto;

    public Controller(InputView inputView, OutputView outputView, Shop shop, LottoCompany lottoCompany) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.shop = shop;
        this.lottoCompany = lottoCompany;
    }

    public List<Lotto> getLottos() {
        int payedMoney = inputView.getPayedMoney();
        List<Lotto> payedLotto = shop.getPayedLotto(payedMoney);
        outputView.printPayedLotto(payedLottos);
        return payedLotto;
    }

    public WinLotto setWinLotto() {
        List<Integer> winLottoNumber = inputView.getWinLottoNumber();
        int bonusNumber = inputView.getBonusNumber();
        return shop.getWinLotto(winLottoNumber,bonusNumber);
    }

}
