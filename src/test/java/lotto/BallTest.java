package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallTest {

    private static final int VALID_NUMBER = 5;

    @DisplayName("Ball과 일치하는 값이면 true를 반환한다.")
    @Test
    void isNumber() throws Exception {
        //given
        Ball ball = new Ball(VALID_NUMBER);
        //when
        boolean isNumber = ball.isNumber(VALID_NUMBER);
        //then
        assertThat(isNumber).isTrue();
    }

    @DisplayName("1-45 이외의 값을 가지는 Ball을 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void createBallWithInvalidNumber(int invalidNumber) {
        assertThatThrownBy(() -> new Ball(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}