package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.assertj.core.util.Maps.newHashMap;
import static org.junit.jupiter.api.Assertions.fail;

public class ShopTest {
    @DisplayName("지불한 금액만큼의 Lotto수가 나오는지 테스트")
    @Test
    void 지불금액_로또_수_테스트() {
        // given
        Shop shop = new Shop(new LottoGenerator());
        int money = 8000;

        // when
        List<Lotto> payedLotto = shop.getPayedLotto(money);

        // then
        assertThat(payedLotto.size()).isEqualTo(8);
    }

}
