package amazon.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 * Created by admin on 2018/3/16.
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p/>
 * Note: The solution set must not contain duplicate subsets.
 * <p/>
 * For example,
 * If nums = [1,2,3], a solution is:
 * <p/>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * facebook ���������㷨�� ���㣺bag tracking
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        //�߽��ж�
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        //bag tracking
        helper(res, new ArrayList<>(), nums, 0);
        return res;

    }

    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        //����ӿ�ֵ ֮��ѭ����1 ���˳�� 1,12,123��Ȼ��list����ɾ�����գ�2�����˳��2,23��Ȼ��list����ɾ�����գ�3 ���3�����list
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            //bag tracking
            helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
