package amazon.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 2018/3/28.
 */
public class MaximumLengthOfPairChainTest {

    int[][] expecteds = {{1,2},{3,4},{2,3}};
    MaximumLengthOfPairChain  maximumLengthOfPairChain= new  MaximumLengthOfPairChain();
    @Test
    public void test1() {

        int actuals = maximumLengthOfPairChain.findLongestChain(expecteds);
        Assert.assertEquals(expecteds, actuals);
    }
}
