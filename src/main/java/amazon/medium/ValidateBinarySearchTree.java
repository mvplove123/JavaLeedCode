package amazon.medium;

import sun.reflect.generics.tree.Tree;

/**
 * 98. Validate Binary Search Tree
 * Created by admin on 2018/3/16.
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p/>
 * Assume a BST is defined as follows:
 * <p/>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 * 2
 * / \
 * 1   3
 * Binary tree [2,1,3], return true.
 * Example 2:
 * 1
 * / \
 * 2   3
 * Binary tree [1,2,3], return false.
 * <p/>
 * ��������������ǰ�ڵ�Ĵ������е���ڵ㣬С���ҽڵ�
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {

        //�߽��ж�
        if (root == null) {
            return true;
        }
        //�ݹ����
        return helper(root, null, null);

    }

    public boolean helper(TreeNode root, Integer min, Integer max) {

        if (root == null) {
            return true;
        }
        //��ǰ��ڵ�ֵ���ڵ������ֵ����false
        if (max != null && root.val >= max) {
            return false;
        }
        //��ǰ�ҽڵ�ֵ���ڵ������ֵ����false
        if (min != null && root.val <= min) {
            return false;
        }
        //�ݹ���ã���ʼ��ڵ����ֵΪroot.val , �ҽڵ���СֵΪroot.val;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);

    }

}
