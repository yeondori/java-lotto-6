package lotto;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validate(Lotto lotto, int bonus) {
        validateRange(bonus);
        validateDuplicateWithLotto(lotto, bonus);
    }

    private void validateRange(int number) {
        if (number<1 || number>45) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateWithLotto(Lotto lotto, int bonus) {
        if (lotto.hasNumber(bonus)) {
            throw new IllegalArgumentException();
        }
    }
}
