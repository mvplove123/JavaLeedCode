package amazon.easy;

/**
 * 606 Created by admin on 2018/3/9.
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder
 * traversing way.
 * <p/>
 * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty
 * parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary
 * tree.
 * <p/>
 * Example 1:
 * Input: Binary tree: [1,2,3,4]
 * 1
 * /   \
 * 2     3
 * /
 * 4
 * <p/>
 * Output: "1(2(4))(3)"
 * <p/>
 * Explanation: Originallay it needs to be "1(2(4)())(3()())",
 * but you need to omit all the unnecessary empty parenthesis pairs.
 * And it will be "1(2(4))(3)".
 * Example 2:
 * Input: Binary tree: [1,2,3,null,4]
 * 1
 * /   \
 * 2     3
 * \
 * 4
 * <p/>
 * Output: "1(2()(4))(3)"
 * <p/>
 * Explanation: Almost the same as the first example,
 * except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and
 * the output.
 */
public class ConstructStringFromBinaryTree {

    public String tree2str(TreeNode t) {

        //边界判断
        if (t == null) {
            return "";
        }

        //根节点插入
        String result = t.val + "";
        //递归左右节点
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        //无左右子节点
        if (left == "" && right == "") {
            return result;
        }
        //左子点为null
        if (left == "") {
            return result + "()" + "(" + right + ")";
        }
        //右子点为null
        if (right == "") {
            return result + "(" + left + ")";
        }
        //都不为null
        return result + "(" + left + ")" + "(" + right + ")";

    }
}
