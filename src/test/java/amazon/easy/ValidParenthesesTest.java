package amazon.easy;

import amazon.easy.ValidParentheses;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 2018/1/18.
 * * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p/>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParenthesesTest {

    ValidParentheses validParentheses = new ValidParentheses();

    String target = "(){}{}[()]";
    boolean expecteds = false;

    @Test
    public void ValidParentheses1() {
        boolean actuals = validParentheses.isValid1(target);
        Assert.assertEquals(expecteds, actuals);
    }





}
