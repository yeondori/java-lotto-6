package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int LOTTO_PRICE = 1_000;

    public List<Lotto> getLottos(int amount) {
        validateAmount(amount);
        return IntStream.range(0, amount/LOTTO_PRICE)
                .mapToObj(i -> Lotto.from(getRandomNumbers()))
                .toList();
    }

    private void validateAmount(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 최소 구매금액은 1,000원입니다");
        }
        if ((amount % LOTTO_PRICE) != 0) {
            throw new IllegalArgumentException("로또는 1,000원 단위로 구매 가능합니다.");
        }
    }

    private List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
