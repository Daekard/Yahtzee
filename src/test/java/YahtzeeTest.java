import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class YahtzeeTest {

    @Test
    public void shouldScoreFiftyPointsOnYahtzee() throws Exception {

        Yahtzee yahtzee = new Yahtzee();
        int[] dice = new int[]{1, 1, 1, 1, 1};

        Assert.assertThat(yahtzee.score(dice), is(50));
    }

    @Test
    public void shouldScoreTwentyFivePointsOnFullHouse() throws Exception {
        Yahtzee yahtzee = new Yahtzee();
        int[] dice = new int[]{1, 1, 3, 3, 3};

        Assert.assertThat(yahtzee.score(dice), is(25));
    }

    @Test
    public void shouldScoreSumOfDiceOnThreeOfAKind() throws Exception {
        Yahtzee yahtzee = new Yahtzee();
        int[] dice = new int[]{1, 2, 3, 3, 3};

        Assert.assertThat(yahtzee.score(dice), is(12));
    }

    @Test
    public void shouldScoreSumOfDiceOnFourOfAKind() throws Exception {
        Yahtzee yahtzee = new Yahtzee();
        int[] dice = new int[]{1, 3, 3, 3, 3};

        Assert.assertThat(yahtzee.score(dice), is(13));
    }

}