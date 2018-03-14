package amazon.easy;

/**
 * Created by admin on 2018/1/26.
 * <p/>
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <p/>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w
 * as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 * <p/>
 * _______6______
 * /              \
 * ___2__          ___8__
 * /      \        /      \
 * 0      _4       7       9
 * /  \
 * 3   5
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2,
 * since a node can be a descendant of itself according to the LCA definition.
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


public class LowestCommonAncestoroFaBinarySearchTree {

    /**
     * 递归形式
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        //判断p，q两个节点是否在左侧
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor1(root.left, p, q);
        } //判断p，q两个节点是否在右侧
        else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor1(root.right, p, q);
            //pq,分居两侧
        } else {
            return root;
        }
    }

    /**
     * 循环形式
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {


        while (true) {
            //判断p，q两个节点是否在左侧，循环到左子树上
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            }
            //判断p，q两个节点是否在右侧，循环到右子树上
            else if (root.val < p.val && root.val < q.val) {
                root = root.right;
                //pq,分居两侧
            } else {
                return root;
            }
        }


    }


}
