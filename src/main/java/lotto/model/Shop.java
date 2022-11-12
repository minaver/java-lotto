package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private int price;
    private int lottoSize;
    private List<Lotto> lottoPayed;

    public Shop(int price){
        this.price = price;
        this.lottoSize = calcLottoSize(price);
        this.lottoPayed = setLottoPayed(this.lottoSize);
    }

    public List<Lotto> getLottoPayed() {
        return this.lottoPayed;
    }

    private int calcLottoSize(int price) {
        priceValidate(price);
        return (price / 1000);
    }

    // lottoSize 만큼의 Lotto 객체를 생성 후 List에 저장
    private List<Lotto> setLottoPayed(int lottoSize) {
        List<Lotto> lottoPayed = new ArrayList<>();

        while (lottoSize > 0) {
            lottoPayed.add(getRandomLotto());
            lottoSize--;
        }

        return lottoPayed;
    }

    private Lotto getRandomLotto(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
    }

    private void priceValidate(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

}
