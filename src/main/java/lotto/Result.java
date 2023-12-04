package lotto;

public enum Result {
    FIRST_PRIZE(6, "6개 일치", 2_000_000_000),
    SECOND_PRIZE(5, "5개 일치, 보너스 볼 일치", 30_000_000),
    THIRD_PRIZE(5, "5개 일치", 1_500_000),
    FOURTH_PRIZE(4, "4개 일치", 50_000),
    FIFTH_PRIZE(3, "3개 일치", 5_000),
    NONE(0, "", 0);

    private final int matchNumbers;
    private final String descript;
    private final long prize;

    Result(int matchNumbers, String descript, long prize) {
        this.matchNumbers = matchNumbers;
        this.descript = descript;
        this.prize = prize;
    }
}