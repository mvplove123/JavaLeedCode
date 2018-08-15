package amazon.medium;

/**
 * 553. Optimal Division
 * Created by admin on 2018/3/28.
 * <p/>
 * Given a list of positive integers, the adjacent integers will perform the float division. For example, [2,3,4] ->
 * 2 / 3 / 4.
 * <p/>
 * However, you can add any number of parenthesis at any position to change the priority of operations. You should
 * find out how to add parenthesis to get the maximum result, and return the corresponding expression in string
 * format. Your expression should NOT contain redundant parenthesis.
 * <p/>
 * Example:
 * Input: [1000,100,10,2]
 * Output: "1000/(100/10/2)"
 * Explanation:
 * 1000/(100/10/2) = 1000/((100/10)/2) = 200
 * However, the bold parenthesis in "1000/((100/10)/2)" are redundant,
 * since they don't influence the operation priority. So you should return "1000/(100/10/2)".
 * <p/>
 * Other cases:
 * 1000/(100/10)/2 = 50
 * 1000/(100/(10/2)) = 50
 * 1000/100/10/2 = 0.5
 * 1000/100/(10/2) = 2
 * Note:
 * <p/>
 * The length of the input array is [1, 10].
 * Elements in the given array will be in range [2, 1000].
 * There is only one optimal division for each test case.
 * <p/>
 * 此题考点数学题 a/(b/c) =a/b*c
 * 数组中n个数字，如果不加括号就是：
 * <p/>
 * x1 / x2 / x3 / ... / xn
 * <p/>
 * 那么我们如何加括号使得其值最大呢，那么就是将x2后面的除数都变成乘数，比如只有三个数字的情况 a / b / c，如果我们在后两个数上加上括号 a / (b / c)，实际上就是a / b *
 * c。而且b永远只能当除数，a也永远只能当被除数。同理，x1只能当被除数，x2只能当除数，但是x3之后的数，只要我们都将其变为乘数，那么得到的值肯定是最大的，所以就只有一种加括号的方式，即:
 * <p/>
 * x1 / (x2 / x3 / ... / xn)
 * <p/>
 * 这样的话就完全不用递归了，这道题就变成了一个道简单的字符串操作的题目了：
 */
public class OptimalDivision {
    public String optimalDivision(int[] nums) {

        //边界条件判断
        String res = "";
        if (nums == null || nums.length == 0) {
            return res;
        }
        //含有一个数字时
        if (nums.length == 1) {
            return res + nums[0];
        }
        //含有2个数字时
        if (nums.length == 2) {
            return res + nums[0] + "/" + nums[1];
        }
        //大于2个数字时，拼接字符
        res = res + nums[0] + "/(" + nums[1];
        for (int i = 2; i < nums.length; i++) {
            res = res + "/" + nums[i];
        }

        res = res + ")";
        return res;


    }
}
