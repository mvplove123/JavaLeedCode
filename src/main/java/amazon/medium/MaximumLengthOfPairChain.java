package amazon.medium;

import java.util.Arrays;

/**
 * 646. Maximum Length of Pair Chain
 * Created by admin on 2018/3/28.
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 * <p/>
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in
 * this fashion.
 * <p/>
 * Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs.
 * You can select pairs in any order.
 * <p/>
 * Example 1:
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 * Note:
 * The number of given pairs will be in the range [1, 1000].
 */
public class MaximumLengthOfPairChain {
    /**
     * 动态规划，dp
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {

        //边界条件
        if (pairs == null || pairs.length == 0) {
            return 0;

        }
        //排序
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));

        //初始化并设值为1
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);

        //循环
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], pairs[i][0] > pairs[j][1] ? dp[j] + 1 : dp[j]);
            }
        }
        return dp[pairs.length - 1];

    }



}
