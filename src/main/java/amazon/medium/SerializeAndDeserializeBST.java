package amazon.medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 449. Serialize and Deserialize BST
 * Created by admin on 2018/3/27.
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
 * stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 * <p/>
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be
 * serialized to a string and this string can be deserialized to the original tree structure.
 * <p/>
 * The encoded string should be as compact as possible.
 * <p/>
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms
 * should be stateless.
 */
public class SerializeAndDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return null;
        }
        //����һ��ջ������ջ�ĺ���ȳ�������
        Stack<TreeNode> st = new Stack<>();
        //�ȰѸ��ڵ����
        st.push(root);
        //��Ϊ�յ������
        while (!st.isEmpty()) {
            //�����ڵ㲢��ֵ
            root = st.pop();
            sb.append(root.val).append(",");
            //��push �ұ߽ڵ㣬pop���ȳ���߽ڵ�
            if (root.right != null) {
                st.push(root.right);
            }
            if (root.left != null) {
                st.push(root.left);
            }
        }
        return sb.toString();


    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //�߽��ж�
        if (data==null || data.length()==0) {
            return null;
        }
        //���ݴ������
        String[] strs = data.split(",");
        Queue<Integer> q = new LinkedList<>();
        for (String str : strs) {
            q.offer(Integer.parseInt(str));
        }

        return getNode(q);
    }
    //���÷��ؽڵ�
    public TreeNode getNode(Queue<Integer> q) {
        if (q.isEmpty()) {
            return null;
        }
        //�������ڵ�
        TreeNode root = new TreeNode(q.poll());
        //�ٴζ������
        Queue<Integer> smallerQueue = new LinkedList<>();
        //Դ���в�Ϊ�ղ��ҵ���ֵС�ڵ�ǰ���ڵ�ֵ
        while (!q.isEmpty() && q.peek() < root.val) {
            //���뵽��������
            smallerQueue.offer(q.poll());
        }
        //������
        root.left = getNode(smallerQueue);
        //������
        root.right = getNode(q);
        return root;


    }

}
