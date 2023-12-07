package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

    private static final int VALID_AMOUNT = 10_000;
    private static final int LOTTO_PRICE = 1_000;
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @DisplayName("로또 구매금액 단위로 구매하면 해당 금액만큼 로또를 발행한다.")
    @Test
    void getLottosWithValidAmount() {
        List<Lotto> lottos = lottoGenerator.getLottos(VALID_AMOUNT);
        assertThat(lottos).hasSize(VALID_AMOUNT / LOTTO_PRICE);
    }


    @DisplayName("구매금액보다 적거나 구매금액 단위에 맞지 않는 경우 예외처리한다.")
    @ParameterizedTest
    @ValueSource(ints = {900, 18300, 0})
    void getLottosWithInvalidAmount(int invalid_amount){
        assertThatThrownBy(() -> lottoGenerator.getLottos(invalid_amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}