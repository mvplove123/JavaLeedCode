package amazon.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 2018/2/3.
 */
public class SetMismatchTest {

    SetMismatch setMismatch = new SetMismatch();
    int [] expect = {3,2};
    @Test
    public void test1() {
        int[] nums = {8,7,3,5,3,6,1,4};
        int []result =setMismatch.findErrorNums(nums);
        Assert.assertArrayEquals(expect,result);
    }


}
