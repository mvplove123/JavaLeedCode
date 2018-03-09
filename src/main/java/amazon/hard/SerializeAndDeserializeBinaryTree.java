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
        //�߽��ж�
        if (root == null) {
            return "";
        }
        StringBuffer res = new StringBuffer();
        //������У���α���
        Queue<TreeNode> queue = new LinkedList<>();
        //������ڵ�
        queue.offer(root);

        while (!queue.isEmpty()) {
            //�����ڵ�
            TreeNode cur = queue.poll();
            //�ڵ�Ϊnull��������ַ���������
            if (cur == null) {
                res.append("null ");
                continue;
            }
            //����ֵ
            res.append(String.valueOf(cur.val) + " ");
            //�����ҽڵ���뵽������
            queue.offer(cur.left);
            queue.offer(cur.right);


        }
        return res.toString();


    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        //�߽��ж�
        if (data == "") {
            return null;
        }
        //�ַ����з�
        String[] str = data.split(" ");

        Queue<TreeNode> queue = new LinkedList<>();
        //���׸��ַ������뵽�������Ϊ���ַ����϶��Ǹ��ڵ�
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        queue.offer(root);
        //ѭ���ַ���
        for (int i = 1; i < str.length; i++) {
            //�����ڵ�
            TreeNode cur = queue.poll();
            //�ַ�����Ϊnull�������
            if (!str[i].equals("null")) {
                //���½ڵ��������������뵽������
                cur.left = new TreeNode(Integer.parseInt(str[i]));
                queue.offer(cur.left);
            }
            //����iֵ
            if (!str[++i].equals("null")) {
                //���½ڵ��������������뵽������
                cur.right = new TreeNode(Integer.parseInt(str[i]));
                queue.offer(cur.right);
            }
        }
        return root;


    }
}
