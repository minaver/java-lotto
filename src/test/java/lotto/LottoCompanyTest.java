package lotto;

import lotto.enums.Grade;
import lotto.vo.WinLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.assertj.core.util.Maps.newHashMap;
import static org.junit.jupiter.api.Assertions.fail;

public class LottoCompanyTest {
    @DisplayName("정확한 당첨 통계가 나오는지 테스트")
    @Test
    void 당첨_통계_테스트() {
        // given
        WinLotto winLotto = new WinLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)),8);
        LottoCompany lottoCompany = new LottoCompany(winLotto);
        Map<Grade, Integer> winStats = lottoCompany.getWinStats(newArrayList(
                new Lotto(List.of(1, 2, 3, 4, 11, 12)),
                new Lotto(List.of(14, 15, 16, 17, 18, 19)),
                new Lotto(List.of(21, 22, 23, 24, 25, 26))));

        // when
        Map<Grade, Integer> compStats = newHashMap(Grade.first,0);
        compStats.put(Grade.second,0);
        compStats.put(Grade.third,0);
        compStats.put(Grade.forth,1);
        compStats.put(Grade.fifth,0);
        compStats.put(Grade.none,2);

        // then
        assertThat(winStats).isEqualTo(compStats);
    }

    @DisplayName("정확한 수익률 계산되는지 테스트")
    @Test
    void 수익률_계산_테스트() {
        // given
        WinLotto winLotto = new WinLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)),8);
        LottoCompany lottoCompany = new LottoCompany(winLotto);
        Map<Grade, Integer> winStats = lottoCompany.getWinStats(newArrayList(
                new Lotto(List.of(1, 2, 3, 4, 11, 12)),
                new Lotto(List.of(14, 15, 16, 17, 18, 19)),
                new Lotto(List.of(21, 22, 23, 24, 25, 26))));

        // when
        Double earningRate = lottoCompany.getEarningRate(3000, winStats);

        // then
        assertThat(earningRate).isEqualTo(1666.7);
    }
}
