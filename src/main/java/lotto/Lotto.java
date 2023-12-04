package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateDuplicate(numbers);
    }

    private void validateNumberRange(int number) {
        if (number<1 || number>45) {
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



}
