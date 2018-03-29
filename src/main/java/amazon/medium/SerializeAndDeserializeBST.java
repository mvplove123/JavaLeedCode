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
        //定义一个栈，运用栈的后进先出的特性
        Stack<TreeNode> st = new Stack<>();
        //先把根节点插入
        st.push(root);
        //不为空的情况下
        while (!st.isEmpty()) {
            //弹出节点并设值
            root = st.pop();
            sb.append(root.val).append(",");
            //先push 右边节点，pop后先出左边节点
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
        //边界判断
        if (data==null || data.length()==0) {
            return null;
        }
        //数据存入队列
        String[] strs = data.split(",");
        Queue<Integer> q = new LinkedList<>();
        for (String str : strs) {
            q.offer(Integer.parseInt(str));
        }

        return getNode(q);
    }
    //调用返回节点
    public TreeNode getNode(Queue<Integer> q) {
        if (q.isEmpty()) {
            return null;
        }
        //弹出根节点
        TreeNode root = new TreeNode(q.poll());
        //再次定义队列
        Queue<Integer> smallerQueue = new LinkedList<>();
        //源队列不为空并且弹出值小于当前跟节点值
        while (!q.isEmpty() && q.peek() < root.val) {
            //加入到左侧队列里
            smallerQueue.offer(q.poll());
        }
        //左子树
        root.left = getNode(smallerQueue);
        //右子树
        root.right = getNode(q);
        return root;


    }

}
