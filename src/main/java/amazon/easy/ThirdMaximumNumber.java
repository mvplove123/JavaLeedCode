package amazon.easy;

/**
 * 414 Created by admin on 2018/1/30.
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return
 * the maximum number. The time complexity must be in O(n).
 * <p/>
 * Example 1:
 * Input: [3, 2, 1]
 * <p/>
 * Output: 1
 * <p/>
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 * <p/>
 * Output: 2
 * <p/>
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 * <p/>
 * Output: 1
 * <p/>
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */
public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        //初始化3个数
        Integer max1 = null, max2 = null, max3 = null;


        for (Integer n : nums) {
            //过滤重复数字
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) {
                continue;
            }
            //max1为null的情况下，则设置最大值，否则整体向后移位
            if (max1 == null || n > max1) {

                max3 = max2;
                max2 = max1;
                max1 = n;
                //小于max1的情况下，max2为null，则max2设置最大值，max2之后整体向后移位
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
                //小于max2的情况下，max3为null，则max3设置最大值
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }

        //比较max3和max1，如果max3为null，则返回max1 最大值，否则返回第三大值max3
        return max3 == null ? max1 : max3;

    }

}
