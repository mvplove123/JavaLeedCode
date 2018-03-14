package amazon.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by admin on 2018/3/6.
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see
 * ordered from top to bottom.
 * <p/>
 * For example:
 * Given the following binary tree,
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * You should return [1, 3, 4].
 */
public class BinaryTreeRightSideView {

    /**
     * 深度优先遍历
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        helper(res, root, 0);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        //长度和层级相等
        if (res.size() == level) {
            res.add(root.val);
        }
        //先递归调用右边，这样就把所有右边的值加进去，调用左边的时候，就会出现层次和长度不同，进而不能添加值
        helper(res, root.right, level + 1);
        helper(res, root.left, level + 1);
    }

    /**
     * 广度优先遍历
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        //定义队列
        Queue<TreeNode> queue = new LinkedList<>();
        //添加根节点
        queue.offer(root);
        //队列不为空的前提下
        while (!queue.isEmpty()) {
            //获取队列长度
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //弹出一个节点
                TreeNode cur = queue.poll();
                //先把根节点插入，0也意味着右节点
                if (i == 0) {
                    res.add(cur.val);
                }
                //把右边的节点添加到队列里
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                //把左边的节点添加到队列里
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
            }
        }

        return res;
    }
}
