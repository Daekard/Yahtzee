import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Yahtzee {

    private static int FULLHOUSE = 25;
    private static int SMALLSTRAIGHT = 30;
    private static int LARGESTRAIGHT = 40;
    private static int YAHTZEE = 50;

    public int score(int[] dice) {
        int score = 0;

        if (isYahtzee(dice)) {
            return YAHTZEE;
        }

        if (isFullHouse(dice)) {
            score = FULLHOUSE;
        }

        if (isThreeOfAKind(dice) || isFourOfAKind(dice)) {
            int sum = sumDice(dice);
            if (sum > score) {
                score = sum;
            }

            return score;
        }

        return scoreStraight(dice);
    }

    public int scoreStraight(int[] dice) {
        int consecutive = countConsecutive(dice);

        if (consecutive == 4) {
            return SMALLSTRAIGHT;
        } else if (consecutive == 5) {
            return LARGESTRAIGHT;
        }

        return 0;
    }

    private int sumDice(int[] dice) {
        return Arrays.stream(dice).sum();
    }

    private boolean isThreeOfAKind(int[] dice) {
        return isNumberOfAKind(dice, 3);
    }

    private boolean isFourOfAKind(int[] dice) {
        return isNumberOfAKind(dice, 4);
    }


    private boolean isYahtzee(int[] dice) {
        return isNumberOfAKind(dice, 5);
    }


    private boolean isFullHouse(int[] dice) {
        return !isNumberOfAKind(dice, 4) && Arrays.stream(dice).distinct().count() == 2;
    }

    private int countConsecutive(int[] dice) {
        List<Integer> distinctSorted = Arrays.stream(dice).distinct().sorted().boxed().collect(Collectors.toList());

        int consecutiveCount = 0;
        for (int i = 1; i < distinctSorted.size(); i++) {
            if (distinctSorted.get(i) - distinctSorted.get(i-1) == 1) {
                consecutiveCount++;
            } else {
                consecutiveCount = 0;
            }
        }

        return consecutiveCount;
    }

    private boolean isNumberOfAKind(int[] dice, int number) {

        for (int i = 0; i < dice.length; i++) {
            int count = 0;
            int current = dice[i];

            for (int j = i; j < dice.length; j++) {
                if (dice[j] == current) {
                    count++;
                }

                if (count == number) {
                    return true;
                }
            }
        }
        return false;
    }
}
