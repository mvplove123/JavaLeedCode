package amazon.easy;

/**
 * Created by admin on 2018/1/26.
 * <p/>
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <p/>
 * According to the definition of LCA on Wikipedia: ��The lowest common ancestor is defined between two nodes v and w
 * as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).��
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
     * �ݹ���ʽ
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        //�ж�p��q�����ڵ��Ƿ������
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor1(root.left, p, q);
        } //�ж�p��q�����ڵ��Ƿ����Ҳ�
        else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor1(root.right, p, q);
            //pq,�־�����
        } else {
            return root;
        }
    }

    /**
     * ѭ����ʽ
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {


        while (true) {
            //�ж�p��q�����ڵ��Ƿ�����࣬ѭ������������
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            }
            //�ж�p��q�����ڵ��Ƿ����Ҳ࣬ѭ������������
            else if (root.val < p.val && root.val < q.val) {
                root = root.right;
                //pq,�־�����
            } else {
                return root;
            }
        }


    }


}
