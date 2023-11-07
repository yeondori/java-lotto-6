package lotto.ui;

import lotto.LottoGenerator;
import lotto.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputManager {
    public int requestAmount() {
        while (true) {
            System.out.println("\n구입금액을 입력해 주세요.");
            try {
                int amount = validatedNumber(readLine());
                LottoGenerator.from(amount);

                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> requestNumbers() {
        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            try {
                return validateNumbers(readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int requestBonus(List<Integer> winningNumbers) {
        while (true) {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            try {
                int bonus = validatedNumber(readLine());
                WinningLotto.of(winningNumbers, bonus);

                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> validateNumbers(String input) {
        if (!input.matches("^[0-9,]+$")) {
            throw new IllegalArgumentException("[ERROR] 숫자와 구분자(,)만 입력 가능합니다.");
        }

        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력하세요.");
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 값이 있습니다.");
        }
        if (numbers.stream().filter((num -> num >= 1 && num <= 45)).count() != 6) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력하세요.");
        }

        return numbers;
    }

    private int validateAmount(String input) {
        validatedNumber(input);

        int amount = Integer.parseInt(input);

        if (amount < 1_000) {
            throw new IllegalArgumentException("[ERROR] 로또의 최소 구매 가능 금액은 1,000원입니다.");
        }
        if (amount % 1_000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1,000원 단위로만 구매 가능합니다.");
        }

        return amount;
    }

    private static int validatedNumber(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
        }
        return Integer.parseInt(input);
    }
}
