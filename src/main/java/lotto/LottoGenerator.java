package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    public List<Lotto> getLottos(int amount) {
        validateAmount(amount);
        return IntStream.range(0, amount)
                .mapToObj(i -> Lotto.from(getRandomNumbers()))
                .collect(Collectors.toList());
    }

    private void validateAmount(int amount) {
    }

    private List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
