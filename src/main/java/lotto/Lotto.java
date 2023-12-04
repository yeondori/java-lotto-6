package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateNumbersRange(List<Integer> numbers) {
        numbers.forEach(
                number -> validateRange(number)
        );
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        long uniqueSize = numbers.stream()
                .distinct()
                .count();
        if (uniqueSize != 6) {
            throw new IllegalArgumentException();
        }
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }
}
