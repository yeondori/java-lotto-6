package lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultManager {
    private final WinningLotto winningLotto;

    public ResultManager(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public Map<Result, Integer> getAllResults(List<Lotto> lottos) {
        return lottos.stream()
                .collect(Collectors.toMap(
                        this::getLottoResult,
                        result -> 1,
                        Integer::sum
                ));
    }

    public Result getLottoResult(Lotto lotto) {
        Lotto winningNumbers = winningLotto.getLotto();
        Ball bonusBall = winningLotto.getBonus();

        int matchNumber = countMatchingNumbers(lotto, winningNumbers);
        boolean matchBonus = hasMatchBonus(lotto, bonusBall);

        return Result.getResult(matchNumber, matchBonus);
    }
    private int countMatchingNumbers(Lotto lotto, Lotto winningNumbers) {
        return lotto.getNumbers().stream()
                .filter(winningNumbers::hasBall)
                .toList()
                .size();
    }

    private boolean hasMatchBonus(Lotto lotto, Ball bonusBall) {
        return lotto.hasBall(bonusBall);
    }
}