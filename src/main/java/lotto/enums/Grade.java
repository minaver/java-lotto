package lotto.enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Grade {
    first(6,2000000000),
    second(5,30000000),
    third(5,1500000),
    forth(4,50000),
    fifth(3,5000),
    none(0,0)
    ;

    private final int correct;
    private final int number;

    Grade(int correct, int number) {
        this.correct = correct;
        this.number = number;
    }

    public int number() {
        return number;
    }

    public int correct() {
        return correct;
    }

    private static final Map<Integer, Grade> BY_NUMBER=
            Stream.of(values()).collect(Collectors.toMap(Grade::number, Function.identity()));

    public static Grade valueOfNumber(int number) {
        return BY_NUMBER.get(number);
    }

}
