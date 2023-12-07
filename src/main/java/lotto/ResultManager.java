package lotto;

public class ResultManager {
    public Result getLottoResult(Lotto lotto, WinningLotto winningLotto) {
        Lotto winningNumbers = winningLotto.getLotto();
        Ball bonusBall = winningLotto.getBonus();

        int matchNumber = countMatchingNumbers(lotto, winningNumbers);
        boolean matchBonus = hasMatchBonus(lotto, bonusBall);

        return Result.getResult(matchNumber, matchBonus);
    }
    public int countMatchingNumbers(Lotto lotto, Lotto winningNumbers) {
        return lotto.getNumbers().stream()
                .filter(winningNumbers::hasBall)
                .toList()
                .size();
    }

    public boolean hasMatchBonus(Lotto lotto, Ball bonusBall) {
        return lotto.hasBall(bonusBall);
    }
}