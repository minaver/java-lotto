package lotto;

import lotto.views.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();

        try {
            List<Lotto> payedLotto = controller.getLottos();
            controller.setWinLotto();
            controller.getStats(payedLotto);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
