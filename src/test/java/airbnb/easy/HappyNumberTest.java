package airbnb.easy;

import airbnb.HappyNumber;
import org.junit.Assert;
import org.junit.Test;

public class HappyNumberTest {

    HappyNumber happyNumber = new  HappyNumber();
    int n=19;
    @Test
    public void test1() {

        boolean action =happyNumber.isHappy(n);
        Assert.assertEquals(true, action);

    }

}