package lotto;

public class WinningLotto {
    private final Lotto lotto;
    private final Ball bonus;

    public WinningLotto(Lotto lotto, Ball bonus) {
        validateDuplicateWithLotto(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validateDuplicateWithLotto(Lotto lotto, Ball bonus) {
        if (lotto.hasBall(bonus)) {
            throw new IllegalArgumentException();
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Ball getBonus() {
        return bonus;
    }
}