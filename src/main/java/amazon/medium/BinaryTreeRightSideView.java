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
     * ������ȱ���
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
        //���ȺͲ㼶���
        if (res.size() == level) {
            res.add(root.val);
        }
        //�ȵݹ�����ұߣ������Ͱ������ұߵ�ֵ�ӽ�ȥ��������ߵ�ʱ�򣬾ͻ���ֲ�κͳ��Ȳ�ͬ�������������ֵ
        helper(res, root.right, level + 1);
        helper(res, root.left, level + 1);
    }

    /**
     * ������ȱ���
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        //�������
        Queue<TreeNode> queue = new LinkedList<>();
        //��Ӹ��ڵ�
        queue.offer(root);
        //���в�Ϊ�յ�ǰ����
        while (!queue.isEmpty()) {
            //��ȡ���г���
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //����һ���ڵ�
                TreeNode cur = queue.poll();
                //�ȰѸ��ڵ���룬0Ҳ��ζ���ҽڵ�
                if (i == 0) {
                    res.add(cur.val);
                }
                //���ұߵĽڵ���ӵ�������
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                //����ߵĽڵ���ӵ�������
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
            }
        }

        return res;
    }
}
