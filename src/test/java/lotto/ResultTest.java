package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("보너스 숫자가 일치하고, 일치하는 개수가 5일 경우 2등이다.")
    @Test
    void getResultWithSecondPrize() throws Exception {
        Result result = Result.getResult(SECOND_AND_THIRD_PRIZE_MATCHING_NUM, true);
        assertThat(result).isEqualTo(Result.SECOND_PRIZE);
    }


}