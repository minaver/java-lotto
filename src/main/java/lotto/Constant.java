package lotto;

public class Constant {

    public static final int lottoSize = 6;
    public static final int lottoNumRangeStart = 1;
    public static final int lottoNumRangeEnd = 45;

    public static final int firstCorrectNum = 6;
    public static final int secondCorrectNum = 5;
    public static final int thirdCorrectNum = 5;
    public static final int forthCorrectNum = 4;
    public static final int fifthCorrectNum = 3;

    public static final int moneyUnit = 1000;

    public static final String inputPayingMoney = "구입금액을 입력해 주세요.";
    public static final String inputWinLottoNum = "당첨 번호를 입력해 주세요.";
    public static final String inputBonusNum = "보너스 번호를 입력해 주세요.";

    public static final String outputPayedLotto = "개를 구매했습니다.";
    public static final String outputWinStatTitle = "당첨 통계\n---";
    public static final String outputWinStat = "%d개 일치 (%s원) - %d개\n"
            + "%d개 일치 (%s원) - %d개\n"
            + "%d개 일치 (%s원) - %d개\n"
            + "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"
            + "%d개 일치 (%s원) - %d개\n";
    public static final String outputTotalEarningRateStart = "총 수익률은 ";
    public static final String outputTotalEarningRateEnd = "%입니다.";

    public static final String errorInvalidTypeMoney = "[ERROR] 잘못된 타입입니다.";
    public static final String errorSmallSizeMoney = "[ERROR] 금액이 너무 적습니다.";
    public static final String errorWrongSizeMoney = "[ERROR] 로또를 살수 없는 금액입니다.";
    public static final String errorWrongBonusNum = "[ERROR] 잘못된 보너스 숫자입니다.";
    public static final String errorWrongSizeLottoNumber = "[ERROR] 로또 번호의 길이가 잘못되었습니다.";
    public static final String errorWrongRangeLottoNumber = "[ERROR] 잘못된 범위의 로또번호가 존재합니다.";
}
