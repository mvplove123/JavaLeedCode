package airbnb.easy;

import airbnb.ContainsDuplicateII;
import org.junit.Assert;
import org.junit.Test;

public class ContainsDuplicateIITest {
    ContainsDuplicateII containsDuplicateII = new  ContainsDuplicateII();
    int nums[] = {2,1,2,3};
    @Test
    public void test1() {

        boolean action =containsDuplicateII.containsNearbyDuplicate(nums,1);
        Assert.assertEquals(true, action);

    }
}