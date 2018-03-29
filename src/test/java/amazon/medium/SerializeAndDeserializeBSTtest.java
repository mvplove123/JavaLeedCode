package amazon.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by admin on 2018/3/16.
 */
public class SerializeAndDeserializeBSTtest {

    String data = "5,3,2,6,7";
    SerializeAndDeserializeBST  serializeAndDeserializeBST = new  SerializeAndDeserializeBST();
    int[] nums = {1,2,3};
    @Test
    public void test1() {
        TreeNode  actuals = serializeAndDeserializeBST.deserialize(data);
        Assert.assertEquals(data, actuals);
    }

}
