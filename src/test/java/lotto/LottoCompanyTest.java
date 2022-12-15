package lotto;

import lotto.enums.Grade;
import lotto.vo.WinLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.fail;

public class LottoCompanyTest {
    @DisplayName("정확한 수익률 계산되는지 테스트")
    @Test
    void 수익률_계산_테스트() {
        // given
        WinLotto winLotto = new WinLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)),8);
        LottoCompany lottoCompany = new LottoCompany(winLotto);

        // when
        Map<Grade, Integer> winStats = lottoCompany.getWinStats(newArrayList(
                new Lotto(List.of(1, 2, 3, 4, 11, 12)),
                new Lotto(List.of(14, 15, 16, 17, 18, 19)),
                new Lotto(List.of(21, 22, 23, 24, 25, 26))));

        Double earningRate = lottoCompany.getEarningRate(3000, winStats);

        // then
        assertThat(earningRate).isEqualTo(1666.7);
    }
}
