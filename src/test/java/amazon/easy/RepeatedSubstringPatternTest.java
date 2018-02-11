package amazon.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 2018/2/5.
 */
public class RepeatedSubstringPatternTest {

    String str = "abab";
    boolean expecteds = true;
    RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();

    @Test
    public void test1() {
        boolean actuals = repeatedSubstringPattern.repeatedSubstringPattern(str);
        Assert.assertEquals(expecteds, actuals);
    }
}
