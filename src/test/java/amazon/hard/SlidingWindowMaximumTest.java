package amazon.hard;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 2018/2/9.
 */
public class SlidingWindowMaximumTest {


    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;

    int[] expected = {3, 3, 5, 5, 6, 7};
    SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();

    @Test
    public void test1() {

        int[] actuals = slidingWindowMaximum.maxSlidingWindow(nums, k);
        Assert.assertArrayEquals(expected, actuals);
    }
}
