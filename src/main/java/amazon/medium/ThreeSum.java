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
 * �ص㣬ȷ��һ����������������������2 sum�����⣬��������
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        //������
        Arrays.sort(nums);
        //��Ϊ������βֵ�����г���-2
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            //������
            int low = i + 1;
            //β����
            int high = nums.length - 1;
            int sum = 0 - nums[i];

            //�̶�i,��ʼѭ������β����
            while (low < high) {
                //������
                if (nums[low] + nums[high] == sum) {
                    //���3��ֵ
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    //������ȥ��
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    //β����ȥ��
                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    //��β����ͬʱ��ǰһ������£
                    low++;
                    high--;
                    //С��sum������Ҫ�����ײ�����
                } else if (nums[low] + nums[high] < sum) {
                    low++;
                } else {
                    //����sum�������β������
                    high--;
                }
            }
        }
        return res;
    }
}
