package lotto.enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Grade {
    first(2000000000),
    second(30000000),
    third(1500000),
    forth(50000),
    fifth(5000)
    ;

    private final int number;

    Grade(int number) {
        this.number = number;
    }

    public int number() {
        return number;
    }

    private static final Map<Integer, Grade> BY_NUMBER=
            Stream.of(values()).collect(Collectors.toMap(Grade::number, Function.identity()));

    public static Grade valueOfNumber(int number) {
        return BY_NUMBER.get(number);
    }

}
