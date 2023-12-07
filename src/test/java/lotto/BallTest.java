package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {
    @Test
    void isNumber() throws Exception {
        //given
        int number = 5;
        Ball ball = new Ball(number);
        //when
        boolean isNumber = ball.isNumber(number);
        //then
        assertThat(isNumber).isTrue();
    }
}