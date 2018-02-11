package amazon.medium;

import amazon.easy.RepeatedSubstringPattern;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by admin on 2018/2/6.
 */
public class LetterCombinationsOFaPhoneNumberTest {

    String str = "23";
    boolean expecteds = true;
    LetterCombinationsOFaPhoneNumber letterCombinationsOFaPhoneNumber = new LetterCombinationsOFaPhoneNumber();

    @Test
    public void test1() {
        List<String> actuals = letterCombinationsOFaPhoneNumber.letterCombinations(str);
        Assert.assertEquals(expecteds, actuals);
    }

    @Test
    public void test2() {
        List<String> actuals = letterCombinationsOFaPhoneNumber.letterCombinations1(str);
        Assert.assertEquals(expecteds, actuals);
    }

}
