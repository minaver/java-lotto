package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numRangeValidate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(Constant.errorWrongSizeLottoNumber);
            throw new IllegalArgumentException();
        }
    }

    private void numRangeValidate(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < Constant.lottoNumRangeStart
                    || number > Constant.lottoNumRangeEnd) {
                System.out.println(Constant.errorWrongRangeLottoNumber);
                throw new IllegalArgumentException();
            }
        }
    }

}
