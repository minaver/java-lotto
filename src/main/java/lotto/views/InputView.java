package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import lotto.Constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public int getPayedMoney() {
        System.out.println(Constant.inputPayingMoney);
        String input = Console.readLine();
        numberTypeValidate(input);
        return Integer.parseInt(input);
    }

    public List<Integer> getWinLottoNumber() {
        System.out.println(Constant.inputWinLottoNum);
        String input = Console.readLine();
        String[] split = input.split(",");
        return Arrays.asList(split).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int getBonusNumber() {
        System.out.println(Constant.inputBonusNum);
        String input = Console.readLine();
        numberTypeValidate(input);
        return Integer.parseInt(input);
    }

    private void numberTypeValidate(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(Constant.errorInvalidTypeMoney);
            throw new NumberFormatException();
        }
    }



}
