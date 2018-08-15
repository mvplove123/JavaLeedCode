package airbnb.easy;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p/>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Example:
 * <p/>
 * Given the sorted array: [-10,-3,0,5,9],
 * <p/>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p/>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums.length == 0 || nums == null) {
            return null;
        }

        return helper(nums, 0, nums.length - 1);
    }

    TreeNode helper(int nums[], int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = (right - left) / 2 + left;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);

        return node;
    }
}