package amazon.easy;

/**
 * Created by admin on 2018/2/3.
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * <p/>
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 * <p/>
 * Example 1:
 * Input:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * Output:
 * Merged tree:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * Note: The merging process must start from the root nodes of both trees.
 */
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        //边界判断，如果t1为null，返回t2,反之返回t1
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        TreeNode newTree = new TreeNode(t1.val + t2.val);
        //左子树递归创建
        newTree.left = mergeTrees(t1.left, t2.left);
        //右子树递归创建
        newTree.right = mergeTrees(t1.right, t2.right);

        return newTree;


    }


}
