package lotto;

public class Ball {
    private final int number;

    public Ball(int number) {
        validateRange(number);
        this.number = number;
    }
}
