package amazon.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * Created by admin on 2018/3/15.
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets
 * in the array which gives the sum of zero.
 * <p/>
 * Note: The solution set must not contain duplicate triplets.
 * <p/>
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * <p/>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * time:O(n^2)
 * space:O(n)
 * 重点，确定一个数，走另外两个数，用2 sum法解题，先排序处理
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        //先排序
        Arrays.sort(nums);
        //因为设置首尾值，所有长度-2
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            //首索引
            int low = i + 1;
            //尾索引
            int high = nums.length - 1;
            int sum = 0 - nums[i];

            //固定i,开始循环，首尾索引
            while (low < high) {
                //如果相等
                if (nums[low] + nums[high] == sum) {
                    //添加3个值
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    //首索引去重
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    //尾索引去重
                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    //首尾索引同时向前一步，靠拢
                    low++;
                    high--;
                    //小于sum，则需要更新首部索引
                } else if (nums[low] + nums[high] < sum) {
                    low++;
                } else {
                    //大于sum，则更新尾部索引
                    high--;
                }
            }
        }
        return res;
    }
}
