package amazon.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 2018/1/30.
 */
public class ThirdMaximumNumberTest {

    ThirdMaximumNumber thirdMaximumNumber = new ThirdMaximumNumber();

    @Test
    public void test1() {

;       int nums [] ={2,2,3,1};

        int result = thirdMaximumNumber.thirdMax(nums);
        Assert.assertEquals(1, result);

    }



}
