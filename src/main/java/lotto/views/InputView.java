package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import lotto.Constant;

import java.util.List;

public class InputView {

    public int getPayedMoney() {
        System.out.println(Constant.inputPayingMoney);
        String input = Console.readLine();
        moneyTypeValidate(input);
        return Integer.parseInt(input);
    }

    public List<Integer> getWinLottoNumber() {

    }

    public int getBonusNumber() {

    }

    private void moneyTypeValidate(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(Constant.errorInvalidTypeMoney);
            throw new NumberFormatException();
        }
    }



}
