package airbnb.easy;

import org.junit.Assert;
import org.junit.Test;

public class SingleNumberTest {

    SingleNumber singleNumber = new  SingleNumber();
    int nums[] = {2,1,2};
    @Test
    public void test1() {

        int action = singleNumber.singleNumber(nums);
        Assert.assertEquals(1, action);

    }

}