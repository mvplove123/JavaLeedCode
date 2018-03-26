package amazon.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by admin on 2018/3/16.
 */
public class SubsetsTest {

    int expecteds = 5;
    Subsets  subsets = new  Subsets();
    int[] nums = {1,2,3};
    @Test
    public void test1() {
        List<List<Integer>> actuals = subsets.subsets(nums);
        Assert.assertEquals(expecteds, actuals);
    }

}
