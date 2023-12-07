package lotto;

import java.util.List;

public class Lotto {
    private final List<Ball> numbers;

    private Lotto(List<Ball> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        validateDuplicate(numbers);
        return new Lotto(parseLottoNumbers(numbers));
    }

    private static List<Ball> parseLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(Ball::new)
                .toList();
    }

    private static void validateDuplicate(List<Integer> numbers) {
        long uniqueSize = numbers.stream()
                .distinct()
                .count();
        if (uniqueSize != 6) {
            throw new IllegalArgumentException();
        }
    }

    public boolean hasBall(Ball ballNumber) {
        return numbers.stream()
                .anyMatch(number -> number.equals(ballNumber));
    }

    public List<Ball> getNumbers() {
        return numbers;
    }
}