package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ResultManagerTest {

    @DisplayName("모든 번호가 일치하는 경우 1등을 반환한다.")
    @Test
    void getResult() {
        //given
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        Ball bonusBall = new Ball(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusBall);
        //when
        ResultManager resultManager = new ResultManager(lotto, winningLotto);

        Result lottoResult = resultManager.getLottoResult();
        //then
        assertThat(lottoResult).isEqualTo(Result.FIRST_PRIZE);
    }

    @DisplayName("보너스 번호를 포함해 6개 번호가 일치하는 경우 2등을 반환한다.")
    @Test
    void getResultWithSecondPrize() {
        //given
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 7));
        Ball bonusBall = new Ball(7);
        Lotto winningNumbers = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 8));

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusBall);
        //when
        ResultManager resultManager = new ResultManager(lotto, winningLotto);

        Result lottoResult = resultManager.getLottoResult();
        //then
        assertThat(lottoResult).isEqualTo(Result.SECOND_PRIZE);
    }
}