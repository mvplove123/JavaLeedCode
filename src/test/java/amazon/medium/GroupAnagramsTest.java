package amazon.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by admin on 2018/3/15.
 */
public class GroupAnagramsTest {


    int expecteds = 5;
    GroupAnagrams  groupAnagrams = new  GroupAnagrams();
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    @Test
    public void test1() {

        List<List<String>> actuals = groupAnagrams.groupAnagrams(strs);
        Assert.assertEquals(expecteds, actuals);
    }
}
