package amazon.medium;

/**
 * 396. Rotate Function
 * Created by admin on 2018/3/19.
 * Given an array of integers A and let n to be its length.
 * <p/>
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function"
 * F on A as follow:
 * <p/>
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 * <p/>
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 * <p/>
 * Note:
 * n is guaranteed to be less than 105.
 * <p/>
 * Example:
 * <p/>
 * A = [4, 3, 2, 6]
 * <p/>
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * <p/>
 * So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 *
 * F(0)->F(1) 理解成带系数f(0)的累积和减去一次不带系数的A的和，加上在F(0)操作上系数为0的那个值*相应的长度
 *
 *
 */
public class RotateFunction {
    public int maxRotateFunction(int[] A) {

        int sum = 0;
        int candidate = 0;
        //先求和，然后再把function和求出
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            candidate += A[i] * i;
        }
        //赋值
        int max = candidate;
        //循环顺时针迭代的次数
        for (int j = 1; j < A.length; j++) {
            //减去第一次不带系数的和，加上上一步系数为0的值*长度
            candidate = candidate - sum + A[j - 1] * A.length;
            //比较大小，取大值
            max = Math.max(max, candidate);
        }

        return max;
    }
}
