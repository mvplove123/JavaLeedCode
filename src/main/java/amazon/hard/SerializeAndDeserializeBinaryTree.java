package amazon.hard;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 297 Created by admin on 2018/3/8.
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p/>
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p/>
 * For example, you may serialize the following tree
 * <p/>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * <p/>
 * <p/>
 * <p/>
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //边界判断
        if (root == null) {
            return "";
        }
        StringBuffer res = new StringBuffer();
        //定义队列，层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        //加入根节点
        queue.offer(root);

        while (!queue.isEmpty()) {
            //弹出节点
            TreeNode cur = queue.poll();
            //节点为null，则更新字符串，继续
            if (cur == null) {
                res.append("null ");
                continue;
            }
            //加入值
            res.append(String.valueOf(cur.val) + " ");
            //把左右节点加入到队列里
            queue.offer(cur.left);
            queue.offer(cur.right);


        }
        return res.toString();


    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        //边界判断
        if (data == "") {
            return null;
        }
        //字符串切分
        String[] str = data.split(" ");

        Queue<TreeNode> queue = new LinkedList<>();
        //把首个字符串放入到队列里，因为首字符串肯定是根节点
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        queue.offer(root);
        //循环字符串
        for (int i = 1; i < str.length; i++) {
            //弹出节点
            TreeNode cur = queue.poll();
            //字符串不为null的情况下
            if (!str[i].equals("null")) {
                //更新节点左子树，并加入到队列里
                cur.left = new TreeNode(Integer.parseInt(str[i]));
                queue.offer(cur.left);
            }
            //更新i值
            if (!str[++i].equals("null")) {
                //更新节点右子树，并加入到队列里
                cur.right = new TreeNode(Integer.parseInt(str[i]));
                queue.offer(cur.right);
            }
        }
        return root;


    }
}
