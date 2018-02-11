package amazon.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 532 Created by admin on 2018/2/5.
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 * <p/>
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Example 2:
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * Example 3:
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * Note:
 * The pairs (i, j) and (j, i) count as the same pair.
 * The length of the array won't exceed 10,000.
 * All the integers in the given input belong to the range: [-1e7, 1e7].
 */
public class KdiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        //考虑边界
        if (k < 0 || nums == null || nums.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        //对数组的元素进行计数放入map中
        for (Integer i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        //循环map每一个元素
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //k等于0，则对value大于等于2的数进行累加，因为大于等于2意味着有相同的值
            if (k == 0) {
                if (entry.getValue() >= 2) {
                    count++;
                }
            //k不等于0，则当前的key+k是否存在map集合里，有则累加
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }

        }
        return count;

    }

}
