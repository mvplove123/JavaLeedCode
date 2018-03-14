package amazon.medium;

/**
 * ��̬�滮˼��
 * 238 Created by admin on 2018/2/8
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product
 * of all the elements of nums except nums[i].
 * <p/>
 * Solve it without division and in O(n).
 * <p/>
 * For example, given [1,2,3,4], return [24,12,8,6].
 * <p/>
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the
 * purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        //�жϱ߽�
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int n = nums.length;
        int res[] = new int[n];

        //�Ե�ǰԪ����ߵ�����Ԫ�ؽ������
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }

        //�Ե�ǰԪ���ұߵ�����Ԫ�غ�֮ǰ��ߵ�Ԫ�����
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {

            res[i] *= right;
            right *= nums[i];

        }

        return res;
    }
}
