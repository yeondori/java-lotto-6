package lotto;

public class WinningLotto {
    private final Lotto lotto;
    private final Ball bonus;

    public WinningLotto(Lotto lotto, Ball bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validate(Lotto lotto, Ball bonus) {
        validateDuplicateWithLotto(lotto, bonus);
    }

    private void validateDuplicateWithLotto(Lotto lotto, Ball bonus) {
        int bonusNumber = bonus.getNumber();
        if (lotto.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
