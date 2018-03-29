package amazon.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 2018/3/29.
 */
public class MaximumWidthOfBinaryTreeTest {

    int[][] expecteds = {{1,2},{3,4},{2,3}};
    String data = "5,3,2,6,7";

    SerializeAndDeserializeBST  serializeAndDeserializeBST = new  SerializeAndDeserializeBST();

    MaximumWidthOfBinaryTree  maximumWidthOfBinaryTree= new  MaximumWidthOfBinaryTree();
    @Test
    public void test1() {

        TreeNode root = serializeAndDeserializeBST.deserialize(data);


        int actuals = maximumWidthOfBinaryTree.widthOfBinaryTree(root);
        Assert.assertEquals(expecteds, actuals);
    }

}
