package amazon.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 2018/1/30.
 */
public class ConvertBSTtoGreaterTreeTest {

    ConvertBSTtoGreaterTree convertBSTtoGreaterTree = new ConvertBSTtoGreaterTree();


    @Test
    public void test1() {

        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(13);

        root.left=left;
        root.right=right;

        TreeNode treeNode = convertBSTtoGreaterTree.convertBST(root);
//        Assert.assertEquals(expecteds, maxProfit);

    }

}
