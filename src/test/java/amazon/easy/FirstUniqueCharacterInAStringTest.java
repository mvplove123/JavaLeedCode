package amazon.easy;

import amazon.easy.FirstUniqueCharacterInAString;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 2018/1/19.
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p/>
 * Examples:
 * <p/>
 * s = "leetcode"
 * return 0.
 * <p/>
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterInAStringTest {
    String b = "abacd";
    int expecteds = 1;
    FirstUniqueCharacterInAString firstUniqueCharacterInAString = new FirstUniqueCharacterInAString();

    @Test
    public void test1() {
        int actuals = firstUniqueCharacterInAString.firstUniqChar(b);
        Assert.assertEquals(expecteds, actuals);
    }

}
