package amazon;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 2018/1/17.
 * <p/>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p/>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p/>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p/>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSumTest {

    TwoSum twoSum = new TwoSum();
    int[] nums = {3, 2, 4,6};
    int target = 9;
    int[] expecteds = {0, 3};

    @Test
    public void TwoSumTest1() {
        int[] actuals = twoSum.twoSum(nums, target);
        Assert.assertArrayEquals(expecteds, actuals);
    }


}
