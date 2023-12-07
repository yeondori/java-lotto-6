package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    private static final int FIRST_PRIZE_MATCHING_NUM = 6;
    private static final int SECOND_AND_THIRD_PRIZE_MATCHING_NUM = 5;
    private static final int FOURTH_PRIZE_MATCHING_NUM = 4;
    private static final int FIFTH_PRIZE_MATCHING_NUM = 3;

    @DisplayName("보너스 숫자여부와 관계없이 일치하 개수가 6일 경우 1등이다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void getResultWithFirstPrize(boolean matchBonus) throws Exception {
        Result result = Result.getResult(FIRST_PRIZE_MATCHING_NUM, matchBonus);
        assertThat(result).isEqualTo(Result.FIRST_PRIZE);
    }

    @DisplayName("보너스 숫자여부와 관계없이 일치하는 개수가 4일 경우 4등이다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void getResultWithFourthPrize(boolean matchBonus) throws Exception {
        Result result = Result.getResult(FOURTH_PRIZE_MATCHING_NUM, matchBonus);
        assertThat(result).isEqualTo(Result.FOURTH_PRIZE);
    }

    @DisplayName("보너스 숫자여부와 관계없이 일치하는 개수가 3일 경우 5등이다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void getResultWithFifthPrize(boolean matchBonus) throws Exception {
        Result result = Result.getResult(FIFTH_PRIZE_MATCHING_NUM, matchBonus);
        assertThat(result).isEqualTo(Result.FIFTH_PRIZE);
    }

    @DisplayName("보너스 숫자여부와 관계없이 일치하는 개수가 3 미만일 경우 낙첨이다.")
    @ParameterizedTest
    @MethodSource("provideParameters")
    void getResultWithNonePrize(int matchNumbers, boolean matchBonus) throws Exception {
        Result result = Result.getResult(matchNumbers, matchBonus);
        assertThat(result).isEqualTo(Result.NONE);
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(2, true),
                Arguments.of(1, true),
                Arguments.of(0, true),
                Arguments.of(2, false),
                Arguments.of(1, false),
                Arguments.of(0, false)
        );
    }

    @DisplayName("보너스 숫자가 일치하고, 일치하는 개수가 5일 경우 2등이다.")
    @Test
    void getResultWithSecondPrize() throws Exception {
        Result result = Result.getResult(SECOND_AND_THIRD_PRIZE_MATCHING_NUM, true);
        assertThat(result).isEqualTo(Result.SECOND_PRIZE);
    }

    @DisplayName("보너스 숫자가 일치하지 않고, 일치하는 개수가 5일 경우 3등이다.")
    @Test
    void getResultWithThirdPrize() throws Exception {
        Result result = Result.getResult(SECOND_AND_THIRD_PRIZE_MATCHING_NUM, false);
        assertThat(result).isEqualTo(Result.THIRD_PRIZE);
    }
}