package lotto;

public class Ball {
    private final int number;

    public Ball(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자의 범위는 1~45입니다.");
        }
    }
}
