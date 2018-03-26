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
 * F(0)->F(1) ���ɴ�ϵ��f(0)���ۻ��ͼ�ȥһ�β���ϵ����A�ĺͣ�������F(0)������ϵ��Ϊ0���Ǹ�ֵ*��Ӧ�ĳ���
 *
 *
 */
public class RotateFunction {
    public int maxRotateFunction(int[] A) {

        int sum = 0;
        int candidate = 0;
        //����ͣ�Ȼ���ٰ�function�����
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            candidate += A[i] * i;
        }
        //��ֵ
        int max = candidate;
        //ѭ��˳ʱ������Ĵ���
        for (int j = 1; j < A.length; j++) {
            //��ȥ��һ�β���ϵ���ĺͣ�������һ��ϵ��Ϊ0��ֵ*����
            candidate = candidate - sum + A[j - 1] * A.length;
            //�Ƚϴ�С��ȡ��ֵ
            max = Math.max(max, candidate);
        }

        return max;
    }
}
