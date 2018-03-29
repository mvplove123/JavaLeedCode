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
    //定义map用于存和出现的频次
    Map<Integer, Integer> map = new HashMap<>();
    //初始化频次
    int fre = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        //边界判断
        if (root == null) {
            return new int[0];
        }

        List<Integer> res = new ArrayList<>();

        helper(res, root);
        //循环list转换数组
        int ret[] = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    /**
     * 递归调用，进行求得频次最高的和
     *
     * @param res
     * @param root
     */
    public void helper(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }

        //先求根节点的和
        int sum = computeSum(root);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        //频次和当前频次相同，则添加
        if (map.get(sum) == fre) {
            res.add(sum);
        }
        //频次大于当前频次，则清空，重新添加
        if (map.get(sum) > fre) {
            res.clear();
            res.add(sum);
        }

        fre = Math.max(fre, map.get(sum));

        helper(res, root.left);
        helper(res, root.right);


    }


    /**
     * 计算各个节点的和，根节点，左子节点，右子节点
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
