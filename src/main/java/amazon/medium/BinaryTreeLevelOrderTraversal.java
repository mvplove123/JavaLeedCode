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
 * //��������α���
 * ��һ�ַ��������У���ÿ���
 * �ڶ��ַ��������������ʵ�ֲ�α�������helper����
 *  time : O(n);
 *  space : O(n);
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder1(TreeNode root) {
        //�߽������ж�
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //�������
        Queue<TreeNode> queue = new LinkedList<>();
        //��Ӹ��ڵ�
        queue.offer(root);
        //ѭ��
        while (!queue.isEmpty()) {
            //ÿһ��ȸ���
            int size = queue.size();
            //ÿһ��list
            List<Integer> list = new ArrayList<>();
            //��ÿһ�����ѭ��,����ӵ������ӵ㲻�ᴦ��ѭ���������Ϊ��size����
            for (int i = 0; i < size; i++) {
                //�����ڵ�
                TreeNode cur = queue.poll();
                //�ж��Ƿ�������ӵ㣬������ӵ�����
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                //�ж��Ƿ�������ӵ㣬������ӵ�����
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                //�ѵ�ǰ�ڵ��ֵ��ӵ�list
                list.add(cur.val);
            }
            //���ÿһ��list
            res.add(list);

        }
        return res;

    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        //�߽������ж�
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(res, root, 0);
        return res;
    }

    /**
     * �ݹ飬�������
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
        //��ȡ��ǰlevel������list���ѵ�ǰֵ��ӵ�res
        res.get(level).add(root.val);

        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);

    }


}
