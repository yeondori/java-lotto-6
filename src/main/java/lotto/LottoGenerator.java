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
        if (amount < 1000) {
            throw new IllegalArgumentException("로또 최소 구매금액은 1,000원입니다");
        }
        if ((amount % 1000) != 0) {
            throw new IllegalArgumentException("로또는 1,000원 단위로 구매 가능합니다.");
        }
    }

    private List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
