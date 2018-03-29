package amazon.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 508 Most Frequent Subtree Sum
 * Created by admin on 2018/3/27.
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is
 * defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
 * So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest
 * frequency in any order.
 * <p/>
 * Examples 1
 * Input:
 * <p/>
 * 5
 * /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 * <p/>
 * 5
 * /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */
public class MostFrequentSubtreeSum {
    //����map���ڴ�ͳ��ֵ�Ƶ��
    Map<Integer, Integer> map = new HashMap<>();
    //��ʼ��Ƶ��
    int fre = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        //�߽��ж�
        if (root == null) {
            return new int[0];
        }

        List<Integer> res = new ArrayList<>();

        helper(res, root);
        //ѭ��listת������
        int ret[] = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    /**
     * �ݹ���ã��������Ƶ����ߵĺ�
     *
     * @param res
     * @param root
     */
    public void helper(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }

        //������ڵ�ĺ�
        int sum = computeSum(root);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        //Ƶ�κ͵�ǰƵ����ͬ�������
        if (map.get(sum) == fre) {
            res.add(sum);
        }
        //Ƶ�δ��ڵ�ǰƵ�Σ�����գ��������
        if (map.get(sum) > fre) {
            res.clear();
            res.add(sum);
        }

        fre = Math.max(fre, map.get(sum));

        helper(res, root.left);
        helper(res, root.right);


    }


    /**
     * ��������ڵ�ĺͣ����ڵ㣬���ӽڵ㣬���ӽڵ�
     *
     * @param root
     * @return
     */
    public int computeSum(TreeNode root) {

        int sum = root.val;
        if (root.left != null) {
            sum += computeSum(root.left);
        }
        if (root.right != null) {
            sum += computeSum(root.right);
        }
        return sum;

    }


}
