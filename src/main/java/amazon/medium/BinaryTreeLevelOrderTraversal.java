package amazon.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 * Created by admin on 2018/3/16.
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p/>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *       3
 *      / \
 *     9  20
 *   /  \
 *  15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * //二叉树层次遍历
 * 第一种方法：队列，按每层存
 * 第二种方法：先序遍历，实现层次遍历，用helper函数
 *  time : O(n);
 *  space : O(n);
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder1(TreeNode root) {
        //边界条件判断
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //定义队列
        Queue<TreeNode> queue = new LinkedList<>();
        //添加根节点
        queue.offer(root);
        //循环
        while (!queue.isEmpty()) {
            //每一层等个数
            int size = queue.size();
            //每一层list
            List<Integer> list = new ArrayList<>();
            //对每一层进行循环,新添加的左右子点不会处于循环队列里，因为有size限制
            for (int i = 0; i < size; i++) {
                //弹出节点
                TreeNode cur = queue.poll();
                //判断是否存在左子点，存在添加到队列
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                //判断是否存在右子点，存在添加到队列
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                //把当前节点的值添加到list
                list.add(cur.val);
            }
            //添加每一层list
            res.add(list);

        }
        return res;

    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        //边界条件判断
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(res, root, 0);
        return res;
    }

    /**
     * 递归，先序遍历
     * @param res
     * @param root
     * @param level
     */
    private void helper(List<List<Integer>> res, TreeNode root, int level) {

        if (root == null) {
            return;
        }
        if (level >= res.size()) {
            res.add(new ArrayList<>());
        }
        //获取当前level索引的list，把当前值添加到res
        res.get(level).add(root.val);

        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);

    }


}
