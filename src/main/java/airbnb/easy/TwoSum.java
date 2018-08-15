package airbnb.easy;
import java.util.HashMap;
import java.util.Map;

/**
 * 1
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p/>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p/>
 * Example:
 * <p/>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p/>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];

            if (numsMap.containsKey(other)) {
                int position = numsMap.get(other);
                return new int[]{position, i};
            } else {
                numsMap.put(nums[i], i);
            }

        }
        return null;
    }
}