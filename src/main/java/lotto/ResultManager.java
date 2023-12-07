package lotto;

public class ResultManager {
    private final Lotto lotto;
    private final WinningLotto winningLotto;

    public ResultManager(Lotto lotto, WinningLotto winningLotto) {
        this.lotto = lotto;
        this.winningLotto = winningLotto;
    }

    public Result getLottoResult() {
        Lotto winningNumbers = winningLotto.getLotto();
        Ball bonusBall = winningLotto.getBonus();

        int matchNumber = countMatchingNumbers(winningNumbers);
        boolean matchBonus = hasMatchBonus(bonusBall);

        return Result.getResult(matchNumber, matchBonus);
    }
    private int countMatchingNumbers(Lotto winningNumbers) {
        return lotto.getNumbers().stream()
                .filter(winningNumbers::hasBall)
                .toList()
                .size();
    }

    public boolean hasMatchBonus(Ball bonusBall) {
        return lotto.hasBall(bonusBall);
    }
}